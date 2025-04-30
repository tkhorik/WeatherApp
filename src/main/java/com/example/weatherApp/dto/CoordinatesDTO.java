package com.example.weatherApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoordinatesDTO {
    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("lat")
    private double latitude;

    // Getters and setters
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}