package com.example.weatherApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherLocationDTO {
    @JsonProperty("name")
    private String cityName;

    @JsonProperty("coord")
    private CoordinatesDTO coordinates;

    @JsonProperty("sys")
    private SysDTO sys;

    @JsonProperty("weather")
    private WeatherDTO[] weather;

    @JsonProperty("main")
    private MainWeatherDTO mainWeather;

    // Getters and setters
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CoordinatesDTO getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDTO coordinates) {
        this.coordinates = coordinates;
    }

    public SysDTO getSys() {
        return sys;
    }

    public void setSys(SysDTO sys) {
        this.sys = sys;
    }

    public WeatherDTO[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherDTO[] weather) {
        this.weather = weather;
    }

    public MainWeatherDTO getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(MainWeatherDTO mainWeather) {
        this.mainWeather = mainWeather;
    }
}