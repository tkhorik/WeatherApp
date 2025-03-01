package com.example.weatherApp.controller;

import com.example.weatherApp.service.UserService;
import com.example.weatherApp.component.SessionHolder;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final UserService userService;
    private final SessionHolder sessionHolder;

    public AuthController(UserService userService, SessionHolder sessionHolder) {
        this.userService = userService;
        this.sessionHolder = sessionHolder;
    }

    /**
     * Displays the login form.
     *
     * @return the name of the login view
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    /**
     * Handles the login request.
     *
     * @param username the username
     * @param password the password
     * @param session the HTTP session
     * @return the redirect URL
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (userService.authenticate(username, password)) {
            sessionHolder.addSession(session.getId(), username);
            return "redirect:/main";
        } else {
            return "redirect:/login?error";
        }
    }

    /**
     * Handles the logout request.
     *
     * @param session the HTTP session
     * @return the redirect URL
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        sessionHolder.removeSession(session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}