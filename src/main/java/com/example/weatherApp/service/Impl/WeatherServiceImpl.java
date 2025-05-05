package com.example.weatherApp.service.Impl;

import com.example.weatherApp.client.WeatherApiClient;
import com.example.weatherApp.model.WeatherResponse;
import com.example.weatherApp.service.WeatherService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

//    @Override
//    public WeatherResponse getWeather(String city) throws Exception {
//        return weatherApiClient.getWeatherByCity(city);
//    }

    @Override
    @Cacheable(value = "weatherCache", key = "#city", unless = "#result == null")
    public WeatherResponse getWeather(String city) {
        // Logic to fetch weather data from the API
        // Example: Call the API and return the response
        return fetchWeatherFromApi(city);
    }

    private WeatherResponse fetchWeatherFromApi(String city) {
        // Actual API call logic
        // Example: Use RestTemplate or WebClient to fetch data
        return new WeatherResponse(); // Replace with actual API response
    }
}