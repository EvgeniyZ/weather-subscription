package com.example.weathersubscription.businesslogic;

import com.example.weathersubscription.businesslogic.contracts.IForecastRepository;
import com.example.weathersubscription.businesslogic.contracts.IWeatherForecastService;
import com.example.weathersubscription.domain.WeatherForecast;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class WeatherForecastService implements IWeatherForecastService {
    private static ConcurrentHashMap<String, WeatherForecast> cityWeatherForecasts;
    private final IForecastRepository forecastRepository;

    public WeatherForecastService(IForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
        cityWeatherForecasts = new ConcurrentHashMap<>();
    }

    @Override
    public WeatherForecast getForecast(String city, String country, ZonedDateTime date) {
        var weatherForecast = cityWeatherForecasts.getOrDefault(city, null);
        if (weatherForecast == null) {
            var forecast = forecastRepository.getDailyForecast(city, country);
            var possible = Arrays.stream(forecast.data).filter(x -> x.timestamp_utc == date).findFirst();
            if (possible.isPresent()) {
                weatherForecast = new WeatherForecast();
                weatherForecast.City = city;
                weatherForecast.Temperature = possible.get().app_max_temp;
                cityWeatherForecasts.putIfAbsent(city, weatherForecast);
            }
        }

        return weatherForecast;
    }
}
