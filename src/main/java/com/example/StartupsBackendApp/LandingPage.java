package com.example.StartupsBackendApp;

public class LandingPage {

    private final long id;
    private final String content;

    public LandingPage(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
