package com.example.weathersubscription.businesslogic.contracts;

import com.example.weathersubscription.domain.WeatherForecast;

import java.time.ZonedDateTime;

public interface IWeatherForecastService {
    WeatherForecast getForecast(final String city, final String country, final ZonedDateTime date);
}
