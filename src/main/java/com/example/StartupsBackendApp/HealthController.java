package com.example.StartupsBackendApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HealthController {

    private static final String template = "Status is %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/health")
    public Health healthStatus(@RequestParam(value = "name", defaultValue = "world") String name){
        return new Health(String.format(template, name), counter.incrementAndGet());
    }
}
