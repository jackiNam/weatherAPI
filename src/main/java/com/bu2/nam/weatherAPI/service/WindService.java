package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelDTO.WindDTO;

public interface WindService {
	void add(WindDTO windDTO);

	void update(WindDTO windDTO);

	void delete(Long id);

	WindDTO getById(Long id);

	List<WindDTO> findWind(SearchDTO searchDTO);

}
