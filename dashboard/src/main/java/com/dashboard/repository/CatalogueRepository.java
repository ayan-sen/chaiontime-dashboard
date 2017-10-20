package com.dashboard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Catalogue;


@Transactional
@Repository
public class CatalogueRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public String add(Catalogue catalogue) {
		catalogue.setCatalogueId(generateId());
		entityManager.persist(catalogue);
		entityManager.flush();
		return catalogue.getCatalogueId();
	}
	
	private String generateId() {
		String sql = "SELECT CONCAT('C',LPAD(IFNULL(MAX(RIGHT(CATALOGUE_ID,9)),  0)+1,10-LENGTH(IFNULL(MAX(RIGHT(CATALOGUE_ID,9)),  0)+1),'0')) AS id FROM CATALOGUE";
		return entityManager.createNativeQuery(sql).getSingleResult().toString();
	}
}
