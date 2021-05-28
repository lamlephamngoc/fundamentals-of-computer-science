package com.goriant.model;

import com.goriant.Constants;

public class UrlStorage {

    private String inputUrl;
    private String outputUrl;

    public UrlStorage(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    public void setInputUrl(String inputUrl) {

        this.inputUrl = inputUrl;
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public String getOutputUrl() {
        return outputUrl;
    }

    public void shortInputUrl(String seoKeyword) {
        this.outputUrl = Constants.SHORT_URL + "/" + seoKeyword;
    }
}
