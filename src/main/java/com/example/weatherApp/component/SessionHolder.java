package com.example.weatherApp.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionHolder {
    private final Map<String, String> sessions = new HashMap<>();

    public void addSession(String sessionId, String username) {
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}