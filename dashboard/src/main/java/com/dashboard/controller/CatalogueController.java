package com.dashboard.controller;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Catalogue;
import com.dashboard.model.Product;
import com.dashboard.model.Stock;
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
	public Catalogue getById(@PathVariable String id) throws ObjectNotFoundException {
		return catalogueService.getById(id);
	}
	
	@PatchMapping("/catalogue")
	public String updateById(@RequestBody Catalogue catalogue) {
		return catalogueService.updateById(catalogue);
	}
	
	@DeleteMapping("/catalogue/{id}")
	public String deleteById(@PathVariable String id) throws ObjectNotFoundException {
		return catalogueService.deleteById(id);
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable String id) throws ObjectNotFoundException {
		return catalogueService.getProductById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable Long id) {
		return catalogueService.deleteProductById(id);
	}
	
	@PutMapping("/stock")
	public Long add(@RequestBody Stock stock) {
		return catalogueService.addStock(stock);
	}
	
	@GetMapping("/stock/{id}")
	public Stock getById(@PathVariable Long id) throws ObjectNotFoundException {
		return catalogueService.findStockById(id);
	}
	
	@PatchMapping("/stock")
	public Long updateStockById(@RequestBody Stock stock) {
		return catalogueService.updateStock(stock);
	}
	
	@DeleteMapping("/stock/{id}")
	public Long deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		return catalogueService.deleteStock(id);
	}
}
