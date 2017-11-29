package com.dashboard.service;

import java.util.Date;
import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.Order;
import com.dashboard.model.OrderDetails;
import com.dashboard.model.RequestContext;
import com.dashboard.repository.OrderRepository;

@Service
public class OrderService {

	@Resource
	private OrderRepository orderRepository;
	
	@Resource
	private EmailService emailService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private RequestContext requestContext;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Order getOrderById(Long orderId) {
		return orderRepository.getOrderById(orderId);
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(Order order) throws ObjectNotFoundException {
		order.setOrderDate(new Date());
		order.setUserId(requestContext.getUser().getUserId());
		List<OrderDetails> details = order.getOrderDetails();
		if(!CollectionUtils.isEmpty(details))
			details.forEach(d -> d.setOrderHeader(order));
		Long orderId = orderRepository.add(order);
		return orderId;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long update(Order order) {
		List<OrderDetails> details = order.getOrderDetails();
		if(!CollectionUtils.isEmpty(details))
			details.forEach(d -> d.setOrderHeader(order));
		return orderRepository.update(order);
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<Order> getAll() {
		return orderRepository.getAll();
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateOrderStatus(Long orderId, String orderStatus) {
		Order order = this.getOrderById(orderId);
		order.setStatus(orderStatus);
		return orderRepository.update(order);
	}
}
