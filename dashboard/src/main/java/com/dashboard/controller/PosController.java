/*package com.dashboard.controller;

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
import com.dashboard.model.Message;
import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;
import com.dashboard.service.PosService;
import com.dashboard.service.PushNotificationService;

@RestController
public class PosController {

	@Resource
	private PosService posService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/pos")
	public Map<String, Object> add(@RequestBody PointOfSale pos) {
		Long id = posService.add(pos);
		pushNotificationService.broadcast(new Message("pos", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "POS created");put("id", id);}};
	}
	
	@GetMapping("/poses")
	public List<PointOfSale> getAll() {
		return posService.getAll();
	}
	
	@GetMapping("/pos/{id}")
	public PointOfSale getById(@PathVariable Long id) throws ObjectNotFoundException {
		return posService.getById(id);
	}
	
	@PatchMapping("/pos")
	public Map<String, Object> updateById(@RequestBody PointOfSale pos) throws ObjectNotFoundException {
		Long id = posService.updateById(pos);
		pushNotificationService.broadcast(new Message("pos", id.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "POS updated");put("id", id);}};
	}
	
	@DeleteMapping("/pos/{id}")
	public Map<String, Object> deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		posService.deleteById(id);
		pushNotificationService.broadcast(new Message("pos", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "POS deleted");put("id", id);}};
	}
	
	@GetMapping("/vendor/{id}")
	public Vendor getVendorById(@PathVariable String id) throws ObjectNotFoundException {
		return posService.getVendorById(id);
	}
	
	@DeleteMapping("/vendor/{id}")
	public Map<String, Object> deleteVendorById(@PathVariable Long id) {
		posService.deleteVendorById(id);
		pushNotificationService.broadcast(new Message("vendor", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "Vendor deleted");put("id", id);}};
	}
}
*/