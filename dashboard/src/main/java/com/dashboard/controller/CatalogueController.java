package com.dashboard.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Catalogue;
import com.dashboard.service.CatalogueService;

@RestController
public class CatalogueController {
	
	@Resource
	private CatalogueService catalogueService;
	
	@PutMapping("/catalogue")
	public String add(@RequestBody Catalogue catalogue) {
		return catalogueService.add(catalogue);
	}
	
	@GetMapping("/catalogues")
	public List<Catalogue> getAll() {
		return catalogueService.getAll();
	}
	
	@GetMapping("/catalogue/{id}")
	public Catalogue getById(@PathVariable String id) {
		return catalogueService.getById(id);
	}
	
	@PatchMapping("/catalogue")
	public String updateById(@RequestBody Catalogue catalogue) {
		return catalogueService.updateById(catalogue);
	}
	
	@DeleteMapping("/catalogue/{id}")
	public String deleteById(@PathVariable String id) {
		return catalogueService.deleteById(id);
	}
	
}
