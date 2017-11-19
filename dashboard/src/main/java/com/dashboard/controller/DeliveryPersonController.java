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
import com.dashboard.model.DeliveryPerson;
import com.dashboard.model.Message;
import com.dashboard.service.DeliveryPersonService;
import com.dashboard.service.PushNotificationService;

@RestController
public class DeliveryPersonController {

	@Resource
	private DeliveryPersonService deliveryPersonService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/deliveryperson")
	public Map<String, Object> add(@RequestBody DeliveryPerson deliveryPerson) {
		Long id = deliveryPersonService.add(deliveryPerson);
		pushNotificationService.broadcast(new Message("deliveryperson", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Delivery Person Added");put("id", id);}};
	}
	
	@GetMapping("/deliverypersons")
	public List<DeliveryPerson> getAll() {
		return deliveryPersonService.getAll();
	}
	
	@GetMapping("/deliveryperson/{id}")
	public DeliveryPerson getById(@PathVariable Long id) throws ObjectNotFoundException {
		return deliveryPersonService.getById(id);
	}
	
	@PatchMapping("/deliveryperson")
	public Map<String, Object> updateById(@RequestBody DeliveryPerson deliveryperson) throws ObjectNotFoundException {
		Long id = deliveryPersonService.updateById(deliveryperson);
		pushNotificationService.broadcast(new Message("deliveryperson", id.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "Delivery Person updated");put("id", id);}};
	}
	
	@DeleteMapping("/deliveryperson/{id}")
	public Map<String, Object> deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		deliveryPersonService.deleteById(id);
		pushNotificationService.broadcast(new Message("deliveryperson", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "Delivery Person removed");put("id", id);}};
	}
}
