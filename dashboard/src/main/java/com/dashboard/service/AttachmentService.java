package com.dashboard.service;

import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dashboard.model.Attachment;
import com.dashboard.repository.AttachmentRepository;

@Service
public class AttachmentService {

	@Resource
	private AttachmentRepository attachmentRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public String addAttachment( MultipartFile file) throws IOException {
		String originalFileName = file.getOriginalFilename();
		String extention = StringUtils.substringAfter(originalFileName, ".");
		String newFileName = getRandomFileName() + "." + extention;
		Attachment attachment = new Attachment(file.getBytes(), newFileName);
		return attachmentRepository.addAttachment(attachment);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Attachment getById(Long id) {
		Attachment attachment = attachmentRepository.getById(id);
		return attachment;
	}

	public Attachment getByFileName(String fileName) {
		Attachment attachment = attachmentRepository.getByFileName(fileName);
		return attachment;
	}
	
	protected String getRandomFileName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
