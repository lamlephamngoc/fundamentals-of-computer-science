package com.goriant.repository;

import com.goriant.Shorter;
import com.goriant.exception.DuplicationException;
import com.goriant.exception.SeoViolateMaxLengthException;
import com.goriant.exception.UrlInvalidException;
import com.goriant.model.UrlStorage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Shorten implements Shorter {
    private static final Shorten INSTANCE = new Shorten();

    private Map<String, UrlStorage> map = new HashMap<>();
    ReentrantLock lock = new ReentrantLock();

    private Shorten() {
    }

    public static Shorten getInstance() {
        return INSTANCE;
    }


    @Override
    public synchronized String shorten(String inputUrl, String seoKeyword) {
        validateInput(inputUrl, seoKeyword);
        UrlStorage urlStorage;

        lock.lock();
        try {
            urlStorage = this.map.get(seoKeyword);
        } finally {
            lock.unlock();
        }

        if (urlStorage != null)
            throw new DuplicationException();

        urlStorage = new UrlStorage(inputUrl);
        urlStorage.shortInputUrl(seoKeyword);

        this.map.put(seoKeyword, urlStorage);

        return urlStorage.getOutputUrl();
    }

    private void validateInput(String inputUrl, String seoKeyword) {
        Objects.requireNonNull(inputUrl);
        Objects.requireNonNull(seoKeyword);

        if (seoKeyword.length() > 20) {
            throw new SeoViolateMaxLengthException();
        }

        try {
            URL url = new URL(inputUrl);
        } catch (MalformedURLException e) {
            throw new UrlInvalidException();
        }
    }

    @Override
    public String originalUrl(String shortUrl) {
        return null;
    }
}
