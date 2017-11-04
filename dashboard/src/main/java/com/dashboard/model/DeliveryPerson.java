package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DELIVERY")
public class DeliveryPerson implements Serializable {  	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DELIVERYBOY_ID")
	private Long deliveryPersonId;
	
	@Column(name="DELIVERYBOY_NAME")
	private String deliveryPersonName;
	
	@Column(name="DELIVERYBOY_ACTIVE")
	private int active=1;
	
	@Column(name="NATIONAL_ID_TYPE")
	private String nationalIdType;
	
	@Column(name="NATIONAL_ID")
	private String nationalId;

	public Long getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public void setDeliveryPersonId(Long deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public void setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getNationalIdType() {
		return nationalIdType;
	}

	public void setNationalIdType(String nationalIdType) {
		this.nationalIdType = nationalIdType;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

}
