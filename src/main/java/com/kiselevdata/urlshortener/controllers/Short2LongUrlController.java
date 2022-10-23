package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.models.Url;
import com.kiselevdata.urlshortener.services.UrlShortenerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sl2")
public class Short2LongUrlController {

    private UrlShortenerService urlShortenerService;
    public Short2LongUrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/{url}")
    public String url(@PathVariable("url") String shortUrl){
        return this.urlShortenerService.short2long(shortUrl);
    }

}
