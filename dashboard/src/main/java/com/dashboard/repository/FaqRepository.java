package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Faq;

@Transactional
@Repository
public class FaqRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(Faq faq) {
		entityManager.persist(faq);
		entityManager.flush();
		return faq.getId();
	}
	
	public List<Faq> getAll() {
		String sql = "SELECT f FROM Faq f";
		return entityManager.createQuery(sql, Faq.class).getResultList();
	}
	
	public Long deleteById(Long id) {
		Faq faq = entityManager.find(Faq.class, id);
		faq.setActive(0);
		entityManager.merge(faq);
		entityManager.flush();
		return faq.getId();
	}
}
