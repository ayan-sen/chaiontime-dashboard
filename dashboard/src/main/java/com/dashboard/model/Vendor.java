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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VENDOR")
public class Vendor implements Serializable {  	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VENDOR_ID")
	private Long vendorId;
	
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Column(name="VENDOR_LONG")
	private Double longitude;
	
	@Column(name="VENDOR_LAT")
	private Double latitude;
	
	@Column(name="VENDOR_ACTIVE")
	private int active=1;
	
	@Column(name="VENDOR_ADDRESS")
	private String vendorAddress;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name = "POS_ID")
	private PointOfSale pointOfSale;

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public PointOfSale getPointOfSale() {
		return pointOfSale;
	}

	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}
	
	public Long getPosId() {
		if(this.pointOfSale != null)
			return pointOfSale.getPosId();
		return null;
	}
	
	
}
