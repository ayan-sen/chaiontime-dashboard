package com.dashboard.repository;

import java.util.List;

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
		entityManager.persist(catalogue);
		entityManager.flush();
		return catalogue.getCatalogueId();
	}

	public List<Catalogue> getAll() {
		String sql = "SELECT c FROM Catalogue c WHERE c.active=1";
		return entityManager.createQuery(sql, Catalogue.class).getResultList();
	}

	public Catalogue getById(String id) {
		return entityManager.find(Catalogue.class, id);
	}

	public String updateById(Catalogue catalogue) {
		entityManager.merge(catalogue);
		entityManager.flush();
		return catalogue.getCatalogueId();
	}

	public String deleteById(String id) {
		Catalogue catalogue = entityManager.find(Catalogue.class, id);
		catalogue.setActive("0");
		entityManager.merge(catalogue);
		entityManager.flush();
		return catalogue.getCatalogueId();
	}
	

}
