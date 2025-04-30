package com.example.weatherApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainWeatherDTO {
    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("humidity")
    private int humidity;

    // Getters and setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}