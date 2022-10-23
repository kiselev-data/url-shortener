package com.kiselevdata.urlshortener.services;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("urlShortenerService")
public class Base64UrlShortenerServiceImpl implements UrlShortenerService {
    @Override
    public String long2short(String url) {
        return Base64.getUrlEncoder().encodeToString(url.getBytes());

    }

    @Override
    public String short2long(String url) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(url);
        return new String(decodedBytes);
    }
}
