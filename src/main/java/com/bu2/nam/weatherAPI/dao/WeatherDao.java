package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Weather;

public interface WeatherDao {
	void add(Weather weather);

	void update(Weather weather);

	void delete(Weather weather);

	Weather getById(Long id);

	List<Weather> findWeather(SearchDTO searchDTO);
}
