package com.example.weatherApp.controller;

import com.example.weatherApp.client.ApiRepository;
import com.example.weatherApp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    private final ApiRepository apiRepository;

    @GetMapping("/api/weather")
    // Changed from "/weather" to "/api/weather"   //http://localhost:8080/api/weather?qcity=London
    public ResponseEntity<String> getWeather(Model model) throws IOException, InterruptedException {

//    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) {
//        try {
//            WeatherResponse response = weatherService.getWeather(city);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(null);
//        }
        String s = apiRepository.fetchWeatherData();
        model.addAttribute("string", s);
        return ResponseEntity.ok(s);
    }
}
// написать для получения погоды
// найти какой джсон нужен для погоды
// как использовать обджект маппер в спринге счтобы из джсона получить набор дто


