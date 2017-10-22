package com.dashboard.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dashboard.model.Attachment;
import com.dashboard.service.AttachmentService;

@RestController
public class AttachmentController {

	@Resource
	private AttachmentService attachmentService;
	
	@PostMapping("/attachment")
	public Long add(@RequestParam(required=true, value="file") MultipartFile file) throws IOException {
		Attachment attachment = new Attachment(file.getBytes(), file.getOriginalFilename());
		return attachmentService.addAttachment(attachment);
	}
	
	@GetMapping("/attachment/{id}")
	public ResponseEntity<InputStreamResource> getFileById(@PathVariable Long id) throws IOException {
		Attachment attachment = attachmentService.getById(id);
		ByteArrayInputStream bis = new ByteArrayInputStream(attachment.getAttachment());
		InputStreamResource resource = new InputStreamResource(bis);
		HttpHeaders resonseHeaders = new HttpHeaders();
		resonseHeaders.setContentType(getMediaType(attachment.getAttachmentName()));
		resonseHeaders.setContentDispositionFormData("attachment", attachment.getAttachmentName());
		
		return new ResponseEntity<InputStreamResource>(resource, resonseHeaders, HttpStatus.OK);
	}

	private MediaType getMediaType(String attachmentName) {
		String extention = StringUtils.substringAfterLast(attachmentName, ".");
		switch(extention.toLowerCase()) {
			case "jpg"  : return MediaType.IMAGE_JPEG;
			case "jpeg" : return MediaType.IMAGE_JPEG;
			case "png"  : return MediaType.IMAGE_PNG;
			case "pdf"  : return MediaType.APPLICATION_PDF;
			default     : return MediaType.IMAGE_JPEG;
		}
	}
}
