package com.example.weathersubscription.repositories.weatherbit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherbitComponent {
    @Value("weather-api-key")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
