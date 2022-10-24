package com.kiselevdata.urlshortener.shorteningservices;

public interface UrlShortenerService {
    String long2short(String url);
    String short2long(String url);
}
