package com.example.weatherApp.client;

import com.example.weatherApp.model.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WeatherApiClient {

    private final ObjectMapper objectMapper;
    private final String apiKey;
    private final String baseUrl;

    public WeatherApiClient(ObjectMapper objectMapper,
                            @Value("${openweathermap.api.key}") String apiKey,
                            @Value("${openweathermap.api.url}") String baseUrl) {
        this.objectMapper = objectMapper;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public WeatherResponse getWeatherByCity(String city) throws IOException {
        String urlString = String.format("%s?q=%s&appid=%s", baseUrl, city, apiKey);
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + responseCode);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        connection.disconnect();

        return objectMapper.readValue(response.toString(), WeatherResponse.class);
    }
}