package org.example.services;

import org.example.models.LatLon;
import org.example.models.WeatherObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/geo/1.0/zip";
    private final String API_KEY = "cf9a1c25ba20f17aaf63e9e3977fac62";

    public LatLon getLatLon(String zipcode){
        String url = API_URL + "?zip=" + zipcode + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);
    }

    public WeatherObject getWeather(LatLon latLon){
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" +
                latLon.getLat() + "&lon=" +
                latLon.getLon() + "&units=imperial&appid=" + API_KEY;

        return template.getForObject(url, WeatherObject.class);
    }

}
