package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_ROLES")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ROLE_ID")
	private String userRoleId;
	
//	@Column(name="USER_ID")
//	private String useId;
	
	@Column(name="ROLE")
	private String role;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name = "USER_ID")
	private User user;
	
	public UserRole() {
		super();
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public String getUserId() {
		return user.getUserId();
	}

	public String getRole() {
		return role;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
