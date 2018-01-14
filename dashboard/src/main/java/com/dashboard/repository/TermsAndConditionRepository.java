package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.TermsAndCondition;

@Transactional
@Repository
public class TermsAndConditionRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(TermsAndCondition termsAndCondition) {
		entityManager.persist(termsAndCondition);
		entityManager.flush();
		return termsAndCondition.getId();
	}
	
	public List<TermsAndCondition> getAll() {
		String sql = "SELECT t FROM TermsAndCondition t";
		return entityManager.createQuery(sql, TermsAndCondition.class).getResultList();
	}
	
	public Long deleteById(Long id) {
		TermsAndCondition termsAndCondition = entityManager.find(TermsAndCondition.class, id);
		termsAndCondition.setActive(0);
		entityManager.merge(termsAndCondition);
		entityManager.flush();
		return termsAndCondition.getId();
	}

	public Long update(TermsAndCondition termsAndCondition) {
		entityManager.merge(termsAndCondition);
		entityManager.flush();
		return termsAndCondition.getId();
	}
}
