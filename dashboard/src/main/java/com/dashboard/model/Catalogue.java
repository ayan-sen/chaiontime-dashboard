package com.dashboard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CATALOGUE")
public class Catalogue implements Serializable {  	

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "catalogue_id_gen", strategy = "com.dashboard.repository.CatalogueIdGenerator")
	@GeneratedValue(generator = "catalogue_id_gen")
	@Column(name="catalogue_id")
	private String catalogueId;
	
	@Column(name="catalogue_name")
	private String catagogueName;
	
	@Column(name="active")
	private String active="1";
	
	@OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;
	
	public Catalogue() {
		super();
	}

	public Catalogue(String catagogueName) {
		super();
		this.catagogueName = catagogueName;
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
}
