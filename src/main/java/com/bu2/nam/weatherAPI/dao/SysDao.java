package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Sys;

public interface SysDao {
	void add(Sys sys);

	void update(Sys sys);

	void delete(Sys sys);

	Sys getById(Long id);

	List<Sys> findSys(SearchDTO searchDTO);
}
