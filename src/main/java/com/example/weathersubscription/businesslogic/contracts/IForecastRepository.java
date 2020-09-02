package com.example.weathersubscription.businesslogic.contracts;

import com.example.weathersubscription.repositories.weatherbit.entities.Forecast;

public interface IForecastRepository {
    Forecast getDailyForecast(final String city, final String country);
}
