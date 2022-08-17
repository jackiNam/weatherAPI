package com.bu2.nam.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bu2.nam.weatherAPI.dao.CoordDao;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Coord;
@Repository
@Transactional
public class CoorDaoImpl implements CoordDao {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void add(Coord coord) {
		entityManager.persist(coord);
		
	}

	@Override
	public void update(Coord coord) {
		entityManager.merge(coord);
		
	}

	@Override
	public void delete(Coord coord) {
		entityManager.remove(coord);
		
	}

	@Override
	public Coord getById(Long id) {
	
		return entityManager.find(Coord.class, id);
	}

	
	//chua lam 
	@Override
	public List<Coord> findCoord(SearchDTO searchDTO) {
		
		return null;
	}

}
