package com.dashboard.service;

import java.util.List;

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

	public List<Catalogue> getAll() {
		return catalogueRepository.getAll();
	}

	public Catalogue getById(String id) {
		return catalogueRepository.getById(id);
	}

	public String updateById(Catalogue catalogue) {
		return catalogueRepository.updateById(catalogue);
	}

	public String deleteById(String id) {
		return catalogueRepository.deleteById(id);
	}
}
