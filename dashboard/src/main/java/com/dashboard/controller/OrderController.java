package com.dashboard.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Order;
import com.dashboard.service.OrderService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
}
