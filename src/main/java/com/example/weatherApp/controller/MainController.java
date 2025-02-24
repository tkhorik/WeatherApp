package com.example.weatherApp.controller;

import com.example.weatherApp.util.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String showIndex() {
        if (SessionManager.getUser() == null) {
            return "redirect:/signin";
        }
        return "index";
    }
}