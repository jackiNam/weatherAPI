package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.City;

public interface CityDao {
	void add(City city);

	void update(City city);

	void delete(City city);

	City getById(Long id);

	List<City> findCity(SearchDTO searchDTO);
}
