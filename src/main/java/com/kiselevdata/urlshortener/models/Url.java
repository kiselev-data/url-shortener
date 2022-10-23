package com.kiselevdata.urlshortener.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Url {
    private String longUrl;
    private String shortUrl;
}
