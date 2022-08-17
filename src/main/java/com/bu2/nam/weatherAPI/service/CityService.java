package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.CityDTO;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;

public interface CityService {
	void add(CityDTO cityDTO);

	void update(CityDTO cityDTO);

	void delete(Long id);

	CityDTO getById(Long id);

	List<CityDTO> findCity(SearchDTO searchDTO);


	
}
