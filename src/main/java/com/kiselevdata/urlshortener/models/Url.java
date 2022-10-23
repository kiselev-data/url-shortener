package com.kiselevdata.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Url {
    private String longUrl;

    private String shortUrl;


}
