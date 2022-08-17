package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.MainDTO;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;

public interface MainService {
	void add(MainDTO mainDTO);

	void update(MainDTO mainDTO);

	void delete(Long id);

	MainDTO getById(Long id);

	List<MainDTO> findMain(SearchDTO searchDTO);

}
