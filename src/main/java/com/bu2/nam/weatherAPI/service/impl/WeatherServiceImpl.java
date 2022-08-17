package com.bu2.nam.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bu2.nam.weatherAPI.dao.WeatherDao;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelDTO.WeatherDTO;
import com.bu2.nam.weatherAPI.modelEntity.City;
import com.bu2.nam.weatherAPI.modelEntity.Weather;
import com.bu2.nam.weatherAPI.service.WeatherService;
import com.bu2.nam.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	WeatherDao weatherDao;

	@Override
	public void add(WeatherDTO weatherDTO) {
		Weather weather = convertToEntity(weatherDTO);
		weatherDao.add(weather);

	}

	@Override
	public void update(WeatherDTO weatherDTO) {
		Weather weather = weatherDao.getById(weatherDTO.getId());
		if (weather != null) {

			weather = convertToEntity(weatherDTO);
			weatherDao.update(weather);

		}

	}

	@Override
	public void delete(Long id) {
		Weather weather = weatherDao.getById(id);
		if (weather != null) {

			weatherDao.delete(weather);
		}

	}

	@Override
	public WeatherDTO getById(Long id) {
		Weather weather = weatherDao.getById(id);
		if (weather != null) {
			WeatherDTO weatherDTO = convertToDTO(weather);

			return weatherDTO;
		}
		return null;
	}

	@Override
	public List<WeatherDTO> findWeather(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public WeatherDTO convertToDTO(Weather weather) {
		WeatherDTO weatherDTO = new WeatherDTO();

		if (weather != null) {

			weatherDTO.setId(weather.getIdWeather());
			weatherDTO.setIdWeather(weather.getId());
			weatherDTO.setIdCity(weather.getId());
			weatherDTO.setDescription(weather.getDescription());
			weatherDTO.setIcon(weather.getIcon());
			weatherDTO.setMain(weather.getMain());
			weatherDTO
					.setCreatedDate(DateTimeUtils.formatDate(weather.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

			return weatherDTO;
		}

		return null;
	}

	public Weather convertToEntity(WeatherDTO weatherDTO) {
		Weather weather = new Weather();

		if (weatherDTO != null) {
			weather.setId(weatherDTO.getIdWeather());
			weather.setDescription(weatherDTO.getDescription());
			weather.setIcon(weatherDTO.getIcon());
			weather.setMain(weatherDTO.getMain());
			City city = new City();
			city.setId(weatherDTO.getIdCity());
			weather.setCity(city);
			return weather;

		}

		return null;
	}

}
