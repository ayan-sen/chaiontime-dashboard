package com.dashboard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private Long phone;
	
	@Column(name = "USER_ADDRESSLINE1")
	private String addressLine1;
	
	@Column(name = "USER_ADDRESSLINE2")
	private String addressLine2;
	
	@Column(name = "USER_CITY")
	private String city;
	
	@Column(name = "USER_STATE")
	private String state;
	
	@Column(name = "USER_POSTALCODE")
	private String pincode;
	
	@Column(name = "USER_COUNTRY")
	private String country;
	
	@Column(name = "USER_WALLETAMT")
	private Double walletAmount;
	
	@Column(name = "USER_ACTIVE")
	private Boolean active=true;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

	
	
	public User() {
		super();
	}

	public User(String userId, String password, String userName, String email,
			Long phone, String addressLine1, String addressLine2, String city,
			String state, String pincode, String country, Double walletAmount,
			String accessRights, Boolean active) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
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

	public Long getPhone() {
		return phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public String getCountry() {
		return country;
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

	
	
	
}



