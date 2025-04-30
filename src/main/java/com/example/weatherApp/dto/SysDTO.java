package com.example.weatherApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SysDTO {
    @JsonProperty("country")
    private String country;

    // Getters and setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}