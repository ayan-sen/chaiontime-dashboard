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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Message;
import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;
import com.dashboard.service.PushNotificationService;
import com.dashboard.service.VendorService;

@RestController
public class VendorController {

	@Resource
	private VendorService vendorService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/vendor")
	public Map<String, Object> add(@RequestBody Vendor vendor) {
		Long id = vendorService.add(vendor);
		pushNotificationService.broadcast(new Message("vendor", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "VENDOR created");put("id", id);}};
	}
	
	@GetMapping("/vendors")
	public List<Vendor> getAll() {
		return vendorService.getAll();
	}
	
	@GetMapping("/vendor/{id}")
	public Vendor getById(@PathVariable Long id) throws ObjectNotFoundException {
		return vendorService.getById(id);
	}
	
	@PatchMapping("/vendor")
	public Map<String, Object> updateById(@RequestBody Vendor vendor) throws ObjectNotFoundException {
		Long id = vendorService.updateById(vendor);
		pushNotificationService.broadcast(new Message("vendor", id.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "VENDOR updated");put("id", id);}};
	}
	
	@DeleteMapping("/vendor/{id}")
	public Map<String, Object> deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		vendorService.deleteById(id);
		pushNotificationService.broadcast(new Message("vendor", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "VENDOR deleted");put("id", id);}};
	}
	
	@GetMapping("/pos/{id}")
	public PointOfSale getPosById(@PathVariable String id) throws ObjectNotFoundException {
		return vendorService.getPointOfSalesById(id);
	}
	
	@DeleteMapping("/pos/{id}")
	public Map<String, Object> deletePointOfSaleById(@PathVariable Long id) {
		vendorService.deletePointOfSaleById(id);
		pushNotificationService.broadcast(new Message("pos", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "POS deleted");put("id", id);}};
	}
	
	@GetMapping("/pos/location")
	public List<PointOfSale> getPosesOfUserLocation(@RequestParam(name="latitude", required=true) String latitude, 
													@RequestParam(name="longitude", required=true) String longitude,
													@RequestParam(name="radious", defaultValue="5", required=false) int radious) {
		return vendorService.getPosNearLocation(latitude, longitude, radious);
	}
}
