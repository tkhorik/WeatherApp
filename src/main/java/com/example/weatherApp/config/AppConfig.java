package com.example.weatherApp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Getter
@Configuration
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class AppConfig {

    @Value("${openweathermap.api.key}")
    private String apiKey;
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}