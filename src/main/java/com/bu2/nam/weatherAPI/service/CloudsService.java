package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.CloudsDTO;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;

public interface CloudsService {
	void add(CloudsDTO cloudsDTO);

	void update(CloudsDTO cloudsDTO);

	void delete(Long id);

	CloudsDTO getById(Long id);

	List<CloudsDTO> findClouds(SearchDTO searchDTO);

}
