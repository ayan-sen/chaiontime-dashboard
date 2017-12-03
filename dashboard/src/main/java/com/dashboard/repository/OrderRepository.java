package com.dashboard.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Order;

@Transactional
@Repository
public class OrderRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(Order order) {
		entityManager.persist(order);
		entityManager.flush();
		return order.getOrderId();
	}
	
	public List<Order> getAll() {
		String sql = "SELECT o FROM Order o ORDER BY o.orderId";
		return entityManager.createQuery(sql, Order.class).getResultList();
	}
	
	public Order getOrderById(Long orderId) {
		return entityManager.find(Order.class, orderId);
	}
	
	public Long update(Order order) {
		entityManager.merge(order);
		entityManager.flush();
		return order.getOrderId();
	}
	
	public Long updateFields(Map<String, Object> mappedFields) {
		Long orderId = (Long) mappedFields.get("orderId");
		mappedFields.remove("orderId");
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaUpdate<Order> update = cb.createCriteriaUpdate(Order.class);
        Root<Order> e = update.from(Order.class);
        mappedFields.forEach((k,v) -> {
        	update.set(k, v);
        });
        update.where(cb.equal(e.get("orderId"), orderId));
        
        this.entityManager.createQuery(update).executeUpdate();
        return orderId;
	}
}
