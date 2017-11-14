package com.dashboard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Order;

@Transactional
@Repository
public class OrderRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Order getOrderById(Long orderId) {
		return entityManager.find(Order.class, orderId);
	}
}
