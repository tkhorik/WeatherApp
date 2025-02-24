package com.example.weatherApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration"; // Refers to registration.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "authorization"; // Refers to authorization.html
    }
}