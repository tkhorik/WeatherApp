package com.example.weatherApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "logout";
    }
    @GetMapping("/weather")
    public String weatherPage() {
        return "index";
    }
}