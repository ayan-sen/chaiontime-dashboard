package com.dashboard.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dashboard.model.Order;
import com.dashboard.repository.OrderRepository;

@Service
public class OrderService {

	@Resource
	private OrderRepository orderRepository;
	
	public Order getOrderById(Long orderId) {
		return orderRepository.getOrderById(orderId);
	}
}
