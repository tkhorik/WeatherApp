package com.example.weatherApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private String name; // City name
    private Main main;  // Temperature, humidity, etc.
    private Weather[] weather; // Weather description

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Main {
        private double temp;
        private int humidity;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weather {
        private String description;
    }
}