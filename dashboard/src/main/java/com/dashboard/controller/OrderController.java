package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Message;
import com.dashboard.model.Order;
import com.dashboard.model.RequestContext;
import com.dashboard.service.OrderService;
import com.dashboard.service.OtpService;
import com.dashboard.service.PushNotificationService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@Resource
	private OtpService otpService;
	
	@Resource
	private RequestContext requestContext;
	
	@PutMapping("/order")
	public Map<String, Object> add(@RequestBody Order order) throws ObjectNotFoundException {
		Long id = orderService.add(order);
		otpService.generateOtp(id.toString(), "ORDER", requestContext.getUser());
		pushNotificationService.broadcast(new Message("order", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Order created");put("id", id);}};
	}
	
	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	@PatchMapping("/order")
	public Map<String, Object> update(@RequestBody Order order) {
		Long id = orderService.update(order);
		pushNotificationService.broadcast(new Message("order", id.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "Order updated");put("id", id);}};
	}
	
	@GetMapping("/orders")
	public List<Order> getAll() {
		return orderService.getAll();
	}
	
	@PostMapping("/order/status")
	public Map<String, Object> updateOrderStatus(@RequestBody Map<String, Object> map) {
		Long orderId = (Long) map.get("orderId");
		String status = (String) map.get("status");
		orderService.updateOrderStatus(orderId, status);
		pushNotificationService.broadcast(new Message("order", orderId.toString(), Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "Order status updated");put("id", orderId);}};
	}
}
