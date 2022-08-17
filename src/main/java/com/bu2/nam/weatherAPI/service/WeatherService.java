package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelDTO.WeatherDTO;

public interface WeatherService {
	void add(WeatherDTO weatherDTO);

	void update(WeatherDTO weatherDTO);

	void delete(Long id);

	WeatherDTO getById(Long id);

	List<WeatherDTO> findWeather(SearchDTO searchDTO);

}
