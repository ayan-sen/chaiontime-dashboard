package com.dashboard.model;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	
	@Column(name="PRODUCT_SIZE")
	private String productSize;
	
	@Column(name="PRODUCT_BUYPRICE")
	private Double productBuyPrice;
	
	@Column(name="PRODUCT_DISCA")
	private String productDisca;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="PRODUCT_DISCSTARTDTE")
	private Date startDate;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="PRODUCT_DISCENDDTE")
	private Date endDate;
	
	@Column(name="PRODUCT_FINALBUYPRICE")
	private Double finalBuyPrice;
	
	@Column(name="UNIT")
	private Long unit;
	
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

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public Double getProductBuyPrice() {
		return productBuyPrice;
	}

	public void setProductBuyPrice(Double productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public String getProductDisca() {
		return productDisca;
	}

	public void setProductDisca(String productDisca) {
		this.productDisca = productDisca;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getFinalBuyPrice() {
		return finalBuyPrice;
	}

	public void setFinalBuyPrice(Double finalBuyPrice) {
		this.finalBuyPrice = finalBuyPrice;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}
}
