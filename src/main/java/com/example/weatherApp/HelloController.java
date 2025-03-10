package com.example.weatherApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hi")
    @ResponseBody
    public String hello() {
        return "Hello, Spring MVC!";
    }
}