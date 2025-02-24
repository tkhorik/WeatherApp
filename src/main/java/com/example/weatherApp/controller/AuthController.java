package com.example.weatherApp.controller;

import com.example.weatherApp.model.UserAccount;
import com.example.weatherApp.service.UserAuthService;
import com.example.weatherApp.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserAuthService authService;

    @GetMapping("/signin")
    public String showSignInForm() {
        return "signin";
    }

    @PostMapping("/signin")
    public String processSignIn(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            UserAccount user = authService.authenticate(username, password);
            SessionManager.setUser(user);
            return "redirect:/index";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "signin";
        }
    }

    @GetMapping("/signout")
    public String signOut() {
        SessionManager.clearSession();
        return "redirect:/signin";
    }
}