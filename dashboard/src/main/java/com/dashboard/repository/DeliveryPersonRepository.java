package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.DeliveryPerson;

@Transactional
@Repository
public class DeliveryPersonRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(DeliveryPerson deliveryPerson) {
		entityManager.persist(deliveryPerson);
		entityManager.flush();
		return deliveryPerson.getDeliveryPersonId();
	}

	public List<DeliveryPerson> getAll() {
		String sql = "SELECT p FROM DeliveryPerson p WHERE p.active=1";
		return entityManager.createQuery(sql, DeliveryPerson.class).getResultList();
	}

	public DeliveryPerson getById(Long id) {
		return entityManager.find(DeliveryPerson.class, id);
	}

	public Long updateById(DeliveryPerson deliveryPerson) {
		entityManager.merge(deliveryPerson);
		entityManager.flush();
		return deliveryPerson.getDeliveryPersonId();
	}

	public Long deleteById(DeliveryPerson deliveryPerson) {
		deliveryPerson.setActive(0);
		entityManager.merge(deliveryPerson);
		entityManager.flush();
		return deliveryPerson.getDeliveryPersonId();
	}
}
