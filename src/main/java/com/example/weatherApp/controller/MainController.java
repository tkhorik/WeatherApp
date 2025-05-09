package com.example.weatherApp.controller;

import com.example.weatherApp.component.SessionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
    private final SessionHolder sessionHolder;

    public MainController(SessionHolder sessionHolder) {
        this.sessionHolder = sessionHolder;
    }

    @GetMapping()
    public String indexPage(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "index";
    }

    @GetMapping("/main")
    public String showMainPage(HttpSession session) {
        String username = sessionHolder.getUsername(session.getId());
        if (username != null) {
            return "main";
        } else {
            return "redirect:/login";
        }
    }
}