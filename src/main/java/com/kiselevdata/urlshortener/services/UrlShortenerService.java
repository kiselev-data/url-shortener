package com.kiselevdata.urlshortener.services;

public interface UrlShortenerService {
    String long2short(String url);
    String short2long(String url);
}
