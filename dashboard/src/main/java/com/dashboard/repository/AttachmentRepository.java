package com.dashboard.repository;

import java.util.List;

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
	
	
	public String addAttachment(Attachment attachment) {
		entityManager.persist(attachment);
		entityManager.flush();
		return attachment.getAttachmentName();
	}


	public Attachment getById(Long id) {
		return entityManager.find(Attachment.class, id);
	}


	public Attachment getByFileName(String fileName) {
		String sql = "SELECT a FROM Attachment a WHERE a.attachmentName = :fileName";
		return entityManager.createQuery(sql, Attachment.class)
				     		.setParameter("fileName", fileName)
							.getSingleResult();
	}
}
