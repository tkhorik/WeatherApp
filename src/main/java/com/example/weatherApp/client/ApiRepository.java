package com.example.weatherApp.client;

import com.example.weatherApp.config.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class ApiRepository {
    private final AppConfig appConfig;

    public String fetchWeatherData() throws IOException, InterruptedException {
        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?q=London&appid=%s", appConfig.getApiKey());
        System.out.println("URL: " + URL);
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