package com.bu2.nam.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bu2.nam.weatherAPI.dao.WeatherDao;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Weather;

@Repository
@Transactional
public class WeatherDaoImpl implements WeatherDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Weather weather) {
		entityManager.persist(weather);

	}

	@Override
	public void update(Weather weather) {
		entityManager.merge(weather);
	}

	@Override
	public void delete(Weather weather) {
	entityManager.remove(weather);

	}

	@Override
	public Weather getById(Long id) {
		
		return entityManager.find(Weather.class, id);
	}

	@Override
	public List<Weather> findWeather(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
