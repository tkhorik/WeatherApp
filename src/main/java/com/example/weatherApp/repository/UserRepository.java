package com.example.weatherApp.repository;

import com.example.weatherApp.model.Session;
import com.example.weatherApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
