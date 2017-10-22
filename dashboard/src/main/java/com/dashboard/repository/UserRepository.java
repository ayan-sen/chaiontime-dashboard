package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dashboard.model.User;


@Repository
public class UserRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public String add(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getUseId();
	}

	public List<User> getAll() {
		String sql = "SELECT u FROM User u WHERE u.active=1";
		return entityManager.createQuery(sql, User.class).getResultList();
	}

	public User getById(String id) {
		return entityManager.find(User.class, id);
	}

	public String updateById(User user) {
		entityManager.merge(user);
		entityManager.flush();
		return user.getUseId();
	}

	public String deleteById(User user) {
		user.setActive(false);
		entityManager.merge(user);
		entityManager.flush();
		return user.getUseId();
	}
}
