package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Main;

public interface MainDao {
	void add(Main main);

	void update(Main main);

	void delete(Main main);

	Main getById(Long id);

	List<Main> findMain(SearchDTO searchDTO);
}
