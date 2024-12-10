package com.example.xmedia;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USERNAME}")
    private String databaseUsername;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    // Getters for accessing these properties
    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }
}
