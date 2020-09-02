package com.example.weathersubscription.repositories.weatherbit;

import com.example.weathersubscription.repositories.weatherbit.configuration.WeatherbitComponent;
import com.example.weathersubscription.businesslogic.contracts.IForecastRepository;
import com.example.weathersubscription.repositories.weatherbit.entities.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class ForecastRepository implements IForecastRepository {
    private final static String baseUrl = "https://api.weatherbit.io/v2.0";
    private final RestTemplate restTemplate;

    @Autowired
    private WeatherbitComponent weatherbitComponent;

    public ForecastRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Forecast getDailyForecast(String city, String country) {
        String url = baseUrl + "/forecast/daily?city=" + city + "&country=" + country + "&key=" + weatherbitComponent.getApiKey();
        var forecast = this.restTemplate.getForObject(url, Forecast.class);

        return forecast;
    }
}
