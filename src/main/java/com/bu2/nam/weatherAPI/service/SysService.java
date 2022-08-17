package com.bu2.nam.weatherAPI.service;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelDTO.SysDTO;

public interface SysService {
	void add(SysDTO sysDTO);

	void update(SysDTO sysDTO);

	void delete(Long id);

	SysDTO getById(Long id);

	List<SysDTO> findSys(SearchDTO searchDTO);

}
