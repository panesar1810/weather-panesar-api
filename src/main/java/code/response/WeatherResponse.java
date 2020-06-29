package code.response;

import code.models.CityInfo;
import code.service.CurrentWeatherService;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherResponse {

    private final CurrentWeatherService currentWeatherService;

    @PostMapping("/current")
    ResponseEntity<?> currentWeatherInfo(@RequestBody CityInfo city) {
        Map<String, Object> info = new HashMap<>();
        info.put("coord", this.currentWeatherService.getCoordinates());
        info.put("disc", this.currentWeatherService.getWeatherDisc());
        info.put("wind", this.currentWeatherService.getWind());
        info.put("main", this.currentWeatherService.getMain());
        info.put("base", this.currentWeatherService.getBase());
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

}
