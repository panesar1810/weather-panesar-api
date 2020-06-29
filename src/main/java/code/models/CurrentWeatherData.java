package code.models;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrentWeatherData {
	
	private Map<String, String> coord;
	private List<Map<String, String>> weather;
	private String base;
	private Map<String, String> main;
	private Map<String, String> wind;
	private Map<String, String> clouds;
	private Long dt;
	private Map<String, String> sys;
	private Integer timezone;
	private Long id;
	private String name;
	private Integer cod;

}