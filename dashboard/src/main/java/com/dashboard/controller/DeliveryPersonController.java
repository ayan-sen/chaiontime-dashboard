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

import com.dashboard.model.DeliveryPerson;
import com.dashboard.service.DeliveryPersonService;

@RestController
public class DeliveryPersonController {

	@Resource
	private DeliveryPersonService deliveryPersonService;
	
	@PutMapping("/deliveryperson")
	public Long add(@RequestBody DeliveryPerson deliveryPerson) {
		return deliveryPersonService.add(deliveryPerson);
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
	public Long updateById(@RequestBody DeliveryPerson deliveryperson) throws ObjectNotFoundException {
		return deliveryPersonService.updateById(deliveryperson);
	}
	
	@DeleteMapping("/deliveryperson/{id}")
	public Long deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		return deliveryPersonService.deleteById(id);
	}
}
