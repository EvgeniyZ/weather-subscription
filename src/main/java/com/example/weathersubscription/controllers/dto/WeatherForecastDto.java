package com.example.weathersubscription.controllers.dto;

public class WeatherForecastDto {
    public String City;
    public int Temperature;

    public WeatherForecastDto(String city, int temperature) {
        City = city;
        Temperature = temperature;
    }
}
