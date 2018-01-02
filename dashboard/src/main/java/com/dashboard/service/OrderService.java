package com.dashboard.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.Order;
import com.dashboard.model.OrderDetails;
import com.dashboard.model.RequestContext;
import com.dashboard.repository.OrderRepository;
import com.razorpay.Payment;

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
	
	@Resource
	private PaymentService paymentService;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Order getOrderById(Long orderId) {
		return orderRepository.getOrderById(orderId);
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(Order order) throws ObjectNotFoundException {
		order.setOrderDate(new Date());
		order.setUserId(requestContext.getUser().getUserId());
		order.setStatus("RECEIVED");
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
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateOrder(Map<String, Object> order) throws Exception {
		Long orderId = ((Integer) order.get("orderId")).longValue();
		String razorpayPaymentId = (String) order.getOrDefault("razorpayPaymentId", "");
		Double totalPrice = (Double) order.getOrDefault("totalPrice", 0.0);
		if(StringUtils.isNotEmpty(razorpayPaymentId) && totalPrice > 0) {
			long paisa = Double.valueOf(totalPrice*100).longValue();
			Payment payment = paymentService.capture(razorpayPaymentId, Long.toString(paisa));
			if(payment != null) {
				long paymentId = paymentService.add(orderId, payment);
				order.put("paymentId", paymentId);
			} else {
				throw new Exception("Payment not captured successfully");
			}
		}
		return orderRepository.updateFields(evaluate(order));
	}
	
	private Map<String, Object> evaluate(Map<String, Object> payload) {
		Map<String, Object> mappedFields = new HashMap<>();
		payload.forEach((k, v) -> {
			if(!k.equals("razorpayPaymentId")) {
				mappedFields.put(k, v);
			}
		});
		return mappedFields;
	}
	
	
}
