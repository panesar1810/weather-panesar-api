package code.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import code.models.CurrentWeatherData;

@Service
public class CurrentWeatherService {

    private final String PREFIX = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String API_KEY = "&appid=cf8bbacd53ad7b00057625e9a2aeb43a";
    private final String UNITS = "&units=metric";

    @Autowired
    private RestTemplate restTemplate;

    private CurrentWeatherData data;

    public void setLocation(final String CITY) {
        final String url = PREFIX + CITY + API_KEY + UNITS;
        this.data = restTemplate.getForObject(url, CurrentWeatherData.class);
    }

    public Map<String, String> getCoordinates() {
        return this.data.getCoord();
    }

    public Map<String, String> getWeatherDisc() {
        return this.data.getWeather().get(0);
    }

    public String getBase() {
        return this.data.getBase();
    }

    public Map<String, String> getMain() {
        return this.data.getMain();
    }

    public Map<String, String> getWind() {
        return this.data.getWind();
    }

}
