package com.example.weatherApp.service;

import com.example.weatherApp.model.UserAccount;
import com.example.weatherApp.repository.UserAccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    private UserAccountRepository repository;

    public UserAccount registerUser(String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username is taken");
        }
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setRole("USER");
        return repository.save(user);
    }

    public UserAccount authenticate(String username, String password) {
        UserAccount user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Incorrect password");
    }
}