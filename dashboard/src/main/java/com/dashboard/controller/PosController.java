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

import com.dashboard.model.PointOfSale;
import com.dashboard.service.PosService;

@RestController
public class PosController {

	@Resource
	private PosService posService;
	
	@PutMapping("/pos")
	public Long add(@RequestBody PointOfSale pos) {
		return posService.add(pos);
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
	public Long updateById(@RequestBody PointOfSale pos) throws ObjectNotFoundException {
		return posService.updateById(pos);
	}
	
	@DeleteMapping("/pos/{id}")
	public Long deleteById(@PathVariable Long id) throws ObjectNotFoundException {
		return posService.deleteById(id);
	}
}
