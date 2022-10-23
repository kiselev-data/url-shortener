package com.kiselevdata.urlshortener.controllers;

import com.kiselevdata.urlshortener.models.Url;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

    @GetMapping
    public Url url(){
        return new Url("a", "b0");
    }

    @GetMapping("/{shortUrl}")
    public Url getShortUrl(@PathVariable("shortUrl") String shortUrl){
        return new Url(shortUrl, "b0");
    }

}
