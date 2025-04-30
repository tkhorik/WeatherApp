package com.example.weatherApp.service;

import com.example.weatherApp.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(String city) throws Exception;
}