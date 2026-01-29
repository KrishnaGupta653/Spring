package com.example.simpleWebApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to the Simple Web App!";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    

}
