package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.CoordDTO;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;

public interface CoordService {
	void add(CoordDTO coordDTO);

	void update(CoordDTO coordDTO);

	void delete(Long id);

	CoordDTO getById(Long id);

	List<CoordDTO> findCoord(SearchDTO searchDTO);

}
