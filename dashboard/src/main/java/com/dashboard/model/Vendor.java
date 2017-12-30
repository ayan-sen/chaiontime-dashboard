package com.dashboard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private String longitude;
	
	@Column(name="VENDOR_LAT")
	private String latitude;
	
	@Column(name="VENDOR_ACTIVE")
	private int active=1;
	
	@Column(name="VENDOR_ADDRESS")
	private String vendorAddress;
	
	@Column(name="POS_ID")
	private Long posId;
	
	@OneToMany(mappedBy = "vendorPos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<PointOfSale> vendorPos;
	
	
	/*@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "POS_ID",referencedColumnName="POS_ID", insertable = false, updatable = false)
	private PointOfSale posVendor;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@Transient
    private Order vendorOrder;

	public List<PointOfSale> getVendorPos() {
		return vendorPos;
	}

	public void setVendorPos(List<PointOfSale> vendorPos) {
		this.vendorPos = vendorPos;
	}

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

	/*public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}
*/
	public Order getVendorOrder() {
		return vendorOrder;
	}

	public void setVendorOrder(Order vendorOrder) {
		this.vendorOrder = vendorOrder;
	}
/*
	public PointOfSale getPosVendor() {
		return posVendor;
	}

	public void setPosVendor(PointOfSale posVendor) {
		this.posVendor = posVendor;
	}
*/
	
}
