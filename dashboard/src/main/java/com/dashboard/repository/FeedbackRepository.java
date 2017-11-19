package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Feedback;

@Transactional
@Repository
public class FeedbackRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(Feedback feedback) {
		entityManager.persist(feedback);
		entityManager.flush();
		return feedback.getOrderId();
	}

	public List<Feedback> getByUserId(String userId) {
		String sql = "SELECT f FROM Feedback f WHERE f.userId=:userId";
		return entityManager.createQuery(sql, Feedback.class).setParameter("userId", userId).getResultList();
	}

	public List<Feedback> getByOrderId(Long id) {
		String sql = "SELECT f FROM Feedback f WHERE f.orderId=:orderId";
		return entityManager.createQuery(sql, Feedback.class).setParameter("orderId", id).getResultList();
	}
}
