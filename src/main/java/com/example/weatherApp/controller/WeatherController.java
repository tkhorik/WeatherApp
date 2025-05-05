package com.example.weatherApp.controller;

import com.example.weatherApp.client.ApiRepository;
import com.example.weatherApp.config.YamlPropertySourceFactory;
import com.example.weatherApp.dto.WeatherLocationDTO;
import com.example.weatherApp.model.WeatherResponse;
import com.example.weatherApp.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class WeatherController {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @GetMapping("/key")
    public ResponseEntity<String> getApiKey() {
        return ResponseEntity.ok("API Key: " + apiKey + ", API URL: " + apiUrl);
    }

    private final WeatherService weatherService;

    private final ApiRepository apiRepository;

    @GetMapping("/api")
    // Changed from "/weather" to "/api/weather"   //http://localhost:8080/api/weather?qcity=London
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam(required = false, value = "city") String city) {
        try {
            WeatherResponse response = weatherService.getWeather(city);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("prop")   //http://localhost:8080/api/weather?qcity=London
    public ResponseEntity<String> getWeather(Model model) throws IOException, InterruptedException {
        String s = apiRepository.fetchWeatherData();
        model.addAttribute("string", s);
        return ResponseEntity.ok(s);
    }

    private final ObjectMapper objectMapper;

//    @PostMapping("/weather")
//    public WeatherLocationDTO processWeather(@RequestBody String json) throws JsonProcessingException, IOException, InterruptedException {
//        // Deserialize JSON to WeatherLocationDTO
//        String s = apiRepository.fetchWeatherData("Londonsxdksjf");
//        WeatherLocationDTO weatherLocation = objectMapper.readValue(s, WeatherLocationDTO.class);
//        return weatherLocation;
//    }
}
