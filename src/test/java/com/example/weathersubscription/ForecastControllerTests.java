package com.example.weathersubscription;

import com.example.weathersubscription.controllers.dto.WeatherForecastDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForecastControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getForecast() throws Exception {
        var city = "Omsk";
        var url = new URL("http://localhost:" + port + "/forecast/" + city);
        ResponseEntity<WeatherForecastDto> response = template.getForEntity(url.toString(), WeatherForecastDto.class);

        //TODO: temperature=1 is hardcoded
        var expected = new WeatherForecastDto(city, 1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().City).isEqualTo(expected.City);
        assertThat(response.getBody().Temperature).isEqualTo(expected.Temperature);
    }
}
