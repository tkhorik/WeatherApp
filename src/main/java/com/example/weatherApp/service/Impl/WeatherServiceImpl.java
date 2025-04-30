package com.example.weatherApp.service.Impl;

import com.example.weatherApp.client.WeatherApiClient;
import com.example.weatherApp.model.WeatherResponse;
import com.example.weatherApp.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    @Override
    public WeatherResponse getWeather(String city) throws Exception {
        return weatherApiClient.getWeatherByCity(city);
    }
}