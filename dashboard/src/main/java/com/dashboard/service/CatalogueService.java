package com.dashboard.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dashboard.model.Catalogue;
import com.dashboard.repository.CatalogueRepository;

@Service
public class CatalogueService {

	@Resource
	private CatalogueRepository catalogueRepository;
	
	public String add(Catalogue catalogue) {
		return catalogueRepository.add(catalogue);
	}
}
