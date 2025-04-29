package com.example.weatherApp.service;

import com.example.weatherApp.dao.UserDao;
import com.example.weatherApp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    public boolean authenticate(String username, String password) {
        User user = userDao.findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
