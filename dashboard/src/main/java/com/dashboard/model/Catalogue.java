package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CATALOGUE")
public class Catalogue implements Serializable {  	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
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

	public void setCatalogueId(String catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getCatalogueId() {
		return catalogueId;
	}

	public String getCatagogueName() {
		return catagogueName;
	}
	
	
	
}
