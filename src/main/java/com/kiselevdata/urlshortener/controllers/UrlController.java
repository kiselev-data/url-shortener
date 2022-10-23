package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.models.Url;
import com.kiselevdata.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {
    private UrlShortenerService urlShortenerService;

    @Autowired
    public UrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }


    @GetMapping("/{url}")
    public String short2long(@PathVariable("url") String shortUrl) {
        return this.urlShortenerService.short2long(shortUrl);
    }

    @PostMapping
    Url long2short(@RequestBody Url url) {
        System.out.println( url);
        String shortUrl = this.urlShortenerService.long2short(url.getLongUrl());
        Url newurl = new Url(url.getLongUrl(), shortUrl);
        return newurl;
    }
}
