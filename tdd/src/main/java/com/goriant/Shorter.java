package com.goriant;

public interface Shorter {
    String shorten(String inputUrl, String seoKeyword);

    String originalUrl(String shortUrl);
}
