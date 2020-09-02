package com.example.weathersubscription.repositories.weatherbit.entities;

import java.time.ZonedDateTime;

public class ForecastData {
    //Apparent/"Feels Like" temperature at max_temp time (default Celcius)
    public int app_max_temp;
    //Apparent/"Feels Like" temperature at min_temp time (default Celcius)
    public int app_min_temp;
    //Average pressure (mb)
    public int pres;
    public ZonedDateTime timestamp_utc;
}
