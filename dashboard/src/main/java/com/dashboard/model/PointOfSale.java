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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POS")
public class PointOfSale implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POS_ID")
	private Long posId;
	
	@Column(name="POS_ACTIVE")
	private int active=1;
	
	@Column(name="POS_AREA")
	private String posArea;
	
	@Column(name="POS_OWNER_NAME")
	private String posOwnerName;
	
	@Column(name="POS_OWNER_MAIL")
	private String posOwnerEmail;
	
	@OneToMany(mappedBy = "pointOfSale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vendor> vendors;

	public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPosArea() {
		return posArea;
	}

	public void setPosArea(String posArea) {
		this.posArea = posArea;
	}

	public String getPosOwnerName() {
		return posOwnerName;
	}

	public void setPosOwnerName(String posOwnerName) {
		this.posOwnerName = posOwnerName;
	}

	public String getPosOwnerEmail() {
		return posOwnerEmail;
	}

	public void setPosOwnerEmail(String posOwnerEmail) {
		this.posOwnerEmail = posOwnerEmail;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	
	
}


