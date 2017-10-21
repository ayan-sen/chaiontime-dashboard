package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CATALOGUE")
public class Catalogue implements Serializable {  	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "catalogue_id_gen", strategy = "com.dashboard.repository.CatalogueIdGenerator")
	@GeneratedValue(generator = "catalogue_id_gen")
	@Column(name="catalogue_id")
	private String catalogueId;
	
	@Column(name="catalogue_name")
	private String catagogueName;
	
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
	
	
	
}
