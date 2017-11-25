package com.dashboard.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.EmailConfig;
import com.dashboard.model.Order;
import com.dashboard.model.OrderDetails;
import com.dashboard.model.User;
import com.dashboard.repository.OrderRepository;

@Service
public class OrderService {

	@Resource
	private OrderRepository orderRepository;
	
	@Resource
	private EmailService emailService;
	
	@Resource
	private UserService userService;
	
	public Order getOrderById(Long orderId) {
		return orderRepository.getOrderById(orderId);
	}
	
	public Long add(Order order) {
		List<OrderDetails> details = order.getOrderDetails();
		if(!CollectionUtils.isEmpty(details))
			details.forEach(d -> d.setOrderHeader(order));
		int otp = generateOneTimePassword();
		order.setOtp(otp);
		
		return orderRepository.add(order);
	}
	
	public Long update(Order order) {
		List<OrderDetails> details = order.getOrderDetails();
		if(!CollectionUtils.isEmpty(details))
			details.forEach(d -> d.setOrderHeader(order));
		return orderRepository.update(order);
	}
	
	public List<Order> getAll() {
		return orderRepository.getAll();
	}
	
	public Long updateOrderStatus(Long orderId, String orderStatus) {
		Order order = this.getOrderById(orderId);
		order.setStatus(orderStatus);
		return orderRepository.update(order);
	}
	
	public Long updateOtp(Long orderId, int otp) {
		Order order = this.getOrderById(orderId);
		order.setOtp(otp);
		return orderRepository.update(order);
	}
	
	public boolean verifyOtp(Long orderId, int otp) {
		Order order = this.getOrderById(orderId);
		boolean status = false;
		if(order.getOtp() == otp) {
			status = true;
		}
		updateOtp(orderId, 0);
		return status;
	}
	
	public Long generateOtp(Long orderId) throws ObjectNotFoundException {
		Order order = this.getOrderById(orderId);
		int otp = generateOneTimePassword();
		User user = userService.getById(order.getUserId());
		String email = user.getEmail();
		updateOtp(orderId, otp);
		EmailConfig config = new EmailConfig(Arrays.asList(email), null, null, "OTP generated for Order #" + orderId, "Order OTP is " + otp);
		emailService.sendEmail(config);
		return orderRepository.update(order);
	}

	private int generateOneTimePassword() {
		Random random = new Random();
		int rand = random.nextInt(9999);
		if(rand < 1000) {
			rand+=1000;
		}
		return rand;
	}
}
