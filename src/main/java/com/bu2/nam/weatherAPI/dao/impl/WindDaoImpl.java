package com.bu2.nam.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bu2.nam.weatherAPI.dao.WindDao;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Wind;

@Repository
@Transactional
public class WindDaoImpl implements WindDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Wind wind) {
		entityManager.persist(wind);

	}

	@Override
	public void update(Wind wind) {
		entityManager.merge(wind);

	}

	@Override
	public void delete(Wind wind) {
		entityManager.remove(wind);

	}

	@Override
	public Wind getById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Wind.class, id);
	}

	@Override
	public List<Wind> findWind(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
