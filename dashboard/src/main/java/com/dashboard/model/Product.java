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
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="active")
	private String active="1";
	
	@Column(name="image_id")
	private String imageId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name = "catalogue_id")
	private Catalogue catalogue;
	
	public Product() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public String getCatalogueId() {
		return catalogue.getCatalogueId();
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public String getActive() {
		return active;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}
