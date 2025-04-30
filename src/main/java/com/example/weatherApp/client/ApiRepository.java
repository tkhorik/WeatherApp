package com.example.weatherApp.client;

import com.example.weatherApp.dto.WeatherLocationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ApiRepository {
    @Autowired
    private ObjectMapper objectMapper;
    // Class for testing only. Remove it after testing.
    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=72f6ad63209d57d0bce611ce5b118206";

    public String fetchWeatherData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:\n" + response.body());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}