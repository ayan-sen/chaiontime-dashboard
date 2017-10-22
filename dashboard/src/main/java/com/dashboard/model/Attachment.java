package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="ATTACHMENT")
public class Attachment implements Serializable {  	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="attachment")
	@Lob
	private byte[] attachment;
	
	@Column(name="attachment_name")
	private String attachmentName;

	public Attachment() {
		super();
	}
	
	public Attachment(byte[] attachment, String attachmentName) {
		super();
		this.attachment = attachment;
		this.attachmentName = attachmentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentName() {
		return attachmentName;
	}
}
