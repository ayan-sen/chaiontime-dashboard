package com.dashboard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.PaymentLog;

@Transactional
@Repository
public class PaymentRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(PaymentLog paymentLog) {
		entityManager.persist(paymentLog);
		entityManager.flush();
		return paymentLog.getPaymentId();
	}
}
