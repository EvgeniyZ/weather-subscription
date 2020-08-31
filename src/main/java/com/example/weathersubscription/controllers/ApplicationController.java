package com.example.weathersubscription.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @RequestMapping("/status")
    public String status() {
        return "healthy";
    }
}
