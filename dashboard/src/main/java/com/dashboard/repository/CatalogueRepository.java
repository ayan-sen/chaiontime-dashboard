package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Catalogue;
import com.dashboard.model.Product;


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

	public String deleteById(Catalogue catalogue) {
		catalogue.setActive("0");
		entityManager.merge(catalogue);
		entityManager.flush();
		return catalogue.getCatalogueId();
	}

	public String deleteProductById(Long id) {
		Product product = entityManager.find(Product.class, id);
		product.setActive("0");
		entityManager.merge(product);
		entityManager.flush();
		return product.getCatalogueId();
	}

	public Product getProductById(String id) {
		return entityManager.find(Product.class, id);
	}
	

}
