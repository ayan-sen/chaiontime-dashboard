package com.dashboard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.Attachment;

@Transactional
@Repository
public class AttachmentRepository {

	@PersistenceContext	
	private EntityManager entityManager;
	
	
	public Long addAttachment(Attachment attachment) {
		entityManager.persist(attachment);
		entityManager.flush();
		return attachment.getId();
	}


	public Attachment getById(Long id) {
		return entityManager.find(Attachment.class, id);
	}
}
