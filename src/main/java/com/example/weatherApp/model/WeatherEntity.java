package com.example.weatherApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity {
    @Id
    private Long id;
    private String city;
    private double temperature;
    private String description;
}