package com.example.weatherApp.repository;

import com.example.weatherApp.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Object> findByUsername(String username);
}