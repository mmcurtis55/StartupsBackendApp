package com.example.StartupsBackendApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LandingPageController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public LandingPage landingPage(@RequestParam(value = "name", defaultValue = "landing page") String name){
        return new LandingPage(counter.incrementAndGet(), String.format(template, name));
    }
}
