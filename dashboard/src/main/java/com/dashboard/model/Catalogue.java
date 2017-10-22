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
@Table(name="CATALOGUE")
public class Catalogue implements Serializable {  	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catalogue_id")
	private String catalogueId;
	
	@Column(name="catalogue_name")
	private String catagogueName;
	
	@Column(name="active")
	private String active="1";
	
	@Column(name="parent")
	private String parent;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image_id")
	private String imageId;
	
	@OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
	
	public Catalogue() {
		super();
	}

	public String getCatalogueId() {
		return catalogueId;
	}

	public String getCatagogueName() {
		return catagogueName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setCatalogueId(String catalogueId) {
		this.catalogueId = catalogueId;
	}

	public void setCatagogueName(String catagogueName) {
		this.catagogueName = catagogueName;
	}
}
