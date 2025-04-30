package com.example.weatherApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hi")
public class PageController {
    @GetMapping("/hi")
    @ResponseBody
    public String hello() {
        return "Hello, Spring MVC!";
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "logout";
    }
//
//    @GetMapping("/weather")
//    public String weatherPage() {
//        return "weather";
//    }
}