package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/l2s")
public class Long2ShortUrlController {

    private UrlShortenerService urlShortenerService;

    @Autowired
    public Long2ShortUrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/{url}")
    public String url(@PathVariable("url") String longUrl){
        return this.urlShortenerService.long2short(longUrl);
    }

}
