package com.example.weatherApp.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class FlywayConfig { // Or add this bean to an existing config class

    @Bean(initMethod = "migrate") // Tells Spring to call migrate() after bean creation
    public Flyway flyway(DataSource dataSource) { // Inject the DataSource bean
        // Standard location for SQL scripts
        // .baselineOnMigrate(true) // Uncomment if applying Flyway to an existing DB
        // .schemas("your_schema_name") // Optional: specify schemas if needed
        // Migration happens automatically due to initMethod="migrate"
        // Or you could explicitly call flyway.migrate() here if not using initMethod
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration") // Standard location for SQL scripts
                // .baselineOnMigrate(true) // Uncomment if applying Flyway to an existing DB
                // .schemas("your_schema_name") // Optional: specify schemas if needed
                .load();
    }
}
