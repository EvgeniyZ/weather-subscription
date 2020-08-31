package com.example.weathersubscription.controllers;

import com.example.weathersubscription.controllers.dto.WeatherForecastDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("forecast")
public class ForecastController {
    @GetMapping("/{city}")
    public WeatherForecastDto getWeatherForecast(@PathVariable String city) {
        return new WeatherForecastDto(city, 1);
    }
}
