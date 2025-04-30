package com.example.weatherApp.repository;

import com.example.weatherApp.model.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}