package com.dashboard.service;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.Attachment;
import com.dashboard.repository.AttachmentRepository;

@Service
public class AttachmentService {

	@Resource
	private AttachmentRepository attachmentRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long addAttachment(Attachment attachment) {
		return attachmentRepository.addAttachment(attachment);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Attachment getById(Long id) {
		Attachment attachment = attachmentRepository.getById(id);
		return attachment;
	}
}
