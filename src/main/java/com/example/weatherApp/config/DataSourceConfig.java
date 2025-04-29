package com.example.weatherApp.config;
// Example using basic DriverManagerDataSource - Replace with your actual DataSource config
// Put this in a Spring @Configuration class (e.g., PersistenceConfig.java)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig { // Or add this bean to an existing config class

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Configure based on your database (PostgreSQL in your case)
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/weather_db"); // CHANGE ME
        dataSource.setUsername("user"); // CHANGE ME
        dataSource.setPassword("user"); // CHANGE ME
        return dataSource;
    }
}
