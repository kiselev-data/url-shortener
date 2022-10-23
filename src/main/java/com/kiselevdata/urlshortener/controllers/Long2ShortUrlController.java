package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/l2s")
public class Long2ShortUrlController {

    private UrlShortenerService urlShortenerService;

    @Autowired
    public Long2ShortUrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }


    @PostMapping("/")
    String long2short(@RequestBody String url) {
        return this.urlShortenerService.long2short(url);
    }

}
