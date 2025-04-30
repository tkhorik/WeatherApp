package com.example.weatherApp.controller;

import com.example.weatherApp.entity.User;
import com.example.weatherApp.service.UserService;
import com.example.weatherApp.component.SessionHolder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    private final SessionHolder sessionHolder;

    public UserController(UserService userService, SessionHolder sessionHolder) {
        this.userService = userService;
        this.sessionHolder = sessionHolder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (userService.authenticate(username, password)) {
            sessionHolder.addSession(session.getId(), username);
            return "redirect:/main";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        sessionHolder.removeSession(session.getId());
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}