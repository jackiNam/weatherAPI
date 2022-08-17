package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Wind;

public interface WindDao {
	void add(Wind wind);

	void update(Wind wind);

	void delete(Wind wind);

	Wind getById(Long id);

	List<Wind> findWind(SearchDTO searchDTO);
}
