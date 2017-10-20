package com.dashboard.controller;

import javax.annotation.Resource;

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
}
