package com.dashboard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="USER")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_PHONE")
	private String phone;
	
	@Column(name = "USER_WALLETAMT")
	private Double walletAmount;
	
	@Column(name = "USER_ACTIVE")
	private Boolean active=true;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<UserRole> userRoles;
	
	@OneToMany(mappedBy = "userAddress", cascade = CascadeType.ALL)
    private List<UserAddress> userAddress;

//	@OneToOne(cascade = CascadeType.ALL)
//	@Transient
//    private Order userOrder;
	
	public User() {
		super();
	}

	public User(String userId, String password, String userName, String email,
			String phone, Double walletAmount,
			String accessRights, Boolean active) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.walletAmount = walletAmount;
		this.active = active;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Double getWalletAmount() {
		return walletAmount;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

//	public Order getUserOrder() {
//		return userOrder;
//	}
//
//	public void setUserOrder(Order userOrder) {
//		this.userOrder = userOrder;
//	}

	
	
	
}



