package com.example.weatherApp.dao;

import com.example.weatherApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private List<User> users;

    // Constructor
    public UserDao() {
        this.users = new ArrayList<>();
    }

    // Getter
    public List<User> getUsers() {
        return users;
    }

    // Setter
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}