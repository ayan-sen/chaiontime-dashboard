package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Message;
import com.dashboard.model.Order;
import com.dashboard.model.OrderStatus;
import com.dashboard.service.OrderService;
import com.dashboard.service.PushNotificationService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/order")
	public Map<String, Object> add(@RequestBody Order order) {
		Long id = orderService.add(order);
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
	
	@PostMapping("/order/{id}/generate/otp")
	public Map<String, Object> generateOtp(@PathVariable Long id) throws ObjectNotFoundException {
		orderService.generateOtp(id);
		pushNotificationService.broadcast(new Message("order", id.toString(), Action.OTP_GENERATED));
		return new HashMap<String, Object>(){{put("message", "Order generated successfully");put("id", id);}};
	}
	
	@PostMapping("/order/verify/otp")
	public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody Map<String, Object> map) {
		Long orderId = Long.parseLong(map.get("orderId").toString());
		int otp = (Integer) map.get("otp");
		boolean verified = orderService.verifyOtp(orderId, otp);
		if(verified) {
			pushNotificationService.broadcast(new Message("order", orderId.toString(), Action.OTP_SUCCESSFUL));
			return new ResponseEntity<>(new HashMap<String, Object>(){{put("message", "OTP verification successful");
																	put("id", orderId);}}, HttpStatus.OK);
		} else {
			pushNotificationService.broadcast(new Message("order", orderId.toString(), Action.OTP_UNSUCCESSFUL));
			return new ResponseEntity<>(new HashMap<String, Object>(){{put("message", "OTP verification unsuccessful");
																	put("id", orderId);}}, HttpStatus.UNAUTHORIZED);
		}
	}
}
