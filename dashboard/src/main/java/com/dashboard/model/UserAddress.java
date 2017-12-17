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
@Table(name="USER_ADDRESS")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ADDRESS_ID")
	private String userAddressId;
	
//	@Column(name="USER_ID")
//	private String useId;
	
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
	
	@Column(name="USER_LONG")
	private String longitude;
	
	@Column(name="USER_LAT")
	private String latitude;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name = "USER_ID")
	private User user;
	
	public UserAddress() {
		super();
	}

	public UserAddress(String addressLine1, String addressLine2, String city,String state,String pincode,String country, String longitude, String latitude) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(String userAddressId) {
		this.userAddressId = userAddressId;
	}
	
	public String getUserId() {
		return user.getUserId();
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}