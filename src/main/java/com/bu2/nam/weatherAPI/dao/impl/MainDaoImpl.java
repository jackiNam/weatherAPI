package com.bu2.nam.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bu2.nam.weatherAPI.dao.MainDao;
import com.bu2.nam.weatherAPI.modelDTO.SearchDTO;
import com.bu2.nam.weatherAPI.modelEntity.Main;
@Repository
@Transactional
public class MainDaoImpl implements MainDao {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void add(Main main) {
	entityManager.persist(main);
		
	}

	@Override
	public void update(Main main) {
		entityManager.merge(main);
		
	}

	@Override
	public void delete(Main main) {
		entityManager.remove(main);
		
	}

	@Override
	public Main getById(Long id) {
		
		return entityManager.find(Main.class, id);
	}

	
	//chua lam 
	@Override
	public List<Main> findMain(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
