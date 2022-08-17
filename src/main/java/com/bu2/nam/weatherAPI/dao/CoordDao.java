package com.bu2.nam.weatherAPI.dao;

import java.util.List;

import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Coord;

public interface CoordDao {
	void add(Coord coord);
	void update(Coord coord);
	void delete(Coord coord);
	Coord getById(Long id);
	List<Coord> findCoord(SearchDTO searchDTO);
}
