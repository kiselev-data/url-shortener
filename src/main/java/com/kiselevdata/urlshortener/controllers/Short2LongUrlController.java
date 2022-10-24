package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.models.Url;
import com.kiselevdata.urlshortener.repositories.UrlRepository;
import com.kiselevdata.urlshortener.shorteningservices.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/s/")
public class Short2LongUrlController {
    private final UrlShortenerService urlShortenerService;
    private final UrlRepository urlRepository;

    @Autowired
    public Short2LongUrlController(UrlShortenerService urlShortenerService,
                                   UrlRepository urlRepository) {
        this.urlShortenerService = urlShortenerService;
        this.urlRepository = urlRepository;
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") long id) {
        return this.urlRepository.findById(id).get().getLongUrl();
    }


    @GetMapping("/yet_another_method/{url}")
    public String get(@PathVariable("url") String shortUrl) {
        List<Url> urls = this.urlRepository.findByShortUrl(shortUrl);
        if (urls.size() > 0) {
            return urls.get(0).getLongUrl();
        } else {
            return null;
        }
    }
}
