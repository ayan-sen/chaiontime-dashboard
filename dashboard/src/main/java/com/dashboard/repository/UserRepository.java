package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dashboard.model.User;

@Transactional
@Repository
public class UserRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public String add(User user) {
		String notEncryptedPassword = user.getPassword();
		user.setPassword(new BCryptPasswordEncoder().encode(notEncryptedPassword));
		entityManager.persist(user);
		entityManager.flush();
		return user.getUserId();
	}

	public List<User> getAll() {
		String sql = "SELECT u FROM User u WHERE u.active=1";
		return entityManager.createQuery(sql, User.class).getResultList();
	}

	public User getById(String id) {
		return entityManager.find(User.class, id);
	}

	public String updateById(User user) {
		String notEncryptedPassword = user.getPassword();
		user.setPassword(new BCryptPasswordEncoder().encode(notEncryptedPassword));
		entityManager.merge(user);
		entityManager.flush();
		return user.getUserId();
	}

	public String deleteById(User user) {
		user.setActive(false);
		entityManager.merge(user);
		entityManager.flush();
		return user.getUserId();
	}
}
