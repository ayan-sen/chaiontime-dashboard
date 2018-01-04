package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Catalogue;
import com.dashboard.model.Message;
import com.dashboard.model.Product;
import com.dashboard.service.CatalogueService;
import com.dashboard.service.PushNotificationService;

@RestController
public class CatalogueController {
	
	@Resource
	private CatalogueService catalogueService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/catalogue")
	public Map<String, Object> add(@RequestBody Catalogue catalogue) {
		String id = catalogueService.add(catalogue);
		pushNotificationService.broadcast(new Message("catalog", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Catalog created");put("id", id);}};
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
	public Map<String, Object> updateById(@RequestBody Catalogue catalogue) {
		String id = catalogueService.updateById(catalogue);
		pushNotificationService.broadcast(new Message("catalog", id.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "Catalog updated");put("id", id);}};
	}
	
	@DeleteMapping("/catalogue/{id}")
	public String deleteById(@PathVariable String id) throws ObjectNotFoundException {
		return catalogueService.deleteById(id);
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable Long id) throws ObjectNotFoundException {
		return catalogueService.getProductById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public Map<String, Object> deleteProductById(@PathVariable Long id) {
		catalogueService.deleteProductById(id);
		pushNotificationService.broadcast(new Message("product", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "Product removed");put("id", id);}};
		
	}
}
