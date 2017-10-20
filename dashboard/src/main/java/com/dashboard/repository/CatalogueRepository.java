package com.dashboard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Catalogue;

@Repository
public class CatalogueRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public String add(Catalogue catalogue) {
		entityManager.persist(catalogue);
		return catalogue.getCatalogueId();
	}
}
