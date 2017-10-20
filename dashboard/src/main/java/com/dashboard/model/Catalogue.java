package com.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catalogue")
public class Catalogue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="catalogue_id")
	private String catalogueId;
	
	@Column(name="catalogue_id")
	private String catagogueName;

	public Catalogue(String catalogueId, String catagogueName) {
		super();
		this.catalogueId = catalogueId;
		this.catagogueName = catagogueName;
	}

	public String getCatalogueId() {
		return catalogueId;
	}

	public String getCatagogueName() {
		return catagogueName;
	}
	
	
	
}
