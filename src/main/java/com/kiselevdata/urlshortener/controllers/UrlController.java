package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.models.Url;
import com.kiselevdata.urlshortener.repositories.UrlRepository;
import com.kiselevdata.urlshortener.shorteningservices.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {
    private final UrlShortenerService urlShortenerService;
    private final UrlRepository urlRepository;

    @Autowired
    public UrlController(UrlShortenerService urlShortenerService,
                         UrlRepository urlRepository) {
        this.urlShortenerService = urlShortenerService;
        this.urlRepository = urlRepository;
    }

    @GetMapping
    public List<Url> list() {
        return this.urlRepository.findAll();
    }

    @GetMapping("/{id}")
    public Url get(@PathVariable("id") long id) {
        return this.urlRepository.findById(id).get();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Url create(@RequestBody Url url) {
        String shortUrl = this.urlShortenerService.long2short(url.getLongUrl());
        url.setShortUrl(shortUrl);
        return this.urlRepository.save(url);
    }
}
