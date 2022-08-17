package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Clouds;

public interface CloudsDao {
	void add(Clouds clouds);

	void update(Clouds clouds);

	void delete(Clouds clouds);

	Clouds getById(Long id);
	
	List<Clouds> findClouds(SearchDTO searchDTO);
}
