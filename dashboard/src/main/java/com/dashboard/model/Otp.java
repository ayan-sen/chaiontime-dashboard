package com.dashboard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name ="OTP")
public class Otp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "ENTITY")
	private String entity;
	
	@Column(name = "OTP")
	private int otp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIMESTAMP")
	private Date timestamp;

	@Column(name = "ENTITY_TYPE")
	private String entityType;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;

	@Transient
	private User user;
	
	public Otp() {
		super();
	}
	
	public Otp(String entity, String entityType, User user) {
		super();
		this.entity = entity;
		this.entityType = entityType;
		this.otp = generateOneTimePassword();
		this.timestamp = new Date();
		this.user = user;
		this.email = user.getEmail();
		this.phone = user.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	private int generateOneTimePassword() {
		Random random = new Random();
		int rand = random.nextInt(9999);
		if(rand < 1000) {
			rand+=1000;
		}
		return rand;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
