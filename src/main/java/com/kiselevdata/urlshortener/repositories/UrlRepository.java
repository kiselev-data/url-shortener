package com.kiselevdata.urlshortener.repositories;

import com.kiselevdata.urlshortener.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    List<Url> findByShortUrl(String shortUrl);
}
