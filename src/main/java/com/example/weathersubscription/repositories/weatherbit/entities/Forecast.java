package com.example.weathersubscription.repositories.weatherbit.entities;

//See https://www.weatherbit.io/api/weather-forecast-16-day
//Field Descriptions section
public class Forecast {
    public String city_name;
    public ForecastData[] data;
}
