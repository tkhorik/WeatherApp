package com.example.weatherApp.service;

import com.example.weatherApp.model.User;
import com.example.weatherApp.repository.SessionRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
//    private SessionRepository repository;
    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setRole("USER");
//        repository.save(user);
    }

    public User authenticate(String username, String password) {
        throw new RuntimeException("Incorrect password");
    }
}