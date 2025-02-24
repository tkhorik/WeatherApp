package com.example.weatherApp.util;

import com.example.weatherApp.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//import javax.servlet.http.HttpSession;

public class SessionManager {

    private static final String USER_KEY = "currentUser";

    public static void setUser(User user) {
        HttpSession session = getCurrentSession();
        session.setAttribute(USER_KEY, user);
    }

    public static User getUser() {
        HttpSession session = getCurrentSession();
        return (User) session.getAttribute(USER_KEY);
    }

    public static void clearSession() {
        HttpSession session = getCurrentSession();
        session.invalidate();
    }

    private static HttpSession getCurrentSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest().getSession(true);
    }
}