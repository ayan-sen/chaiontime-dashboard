package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Feedback;
import com.dashboard.model.Message;
import com.dashboard.service.FeedbackService;
import com.dashboard.service.PushNotificationService;

@RestController
public class FeedbackController {

	@Resource
	private FeedbackService feedbackService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/feedback")
	public Map<String, Object> add(@RequestBody Feedback feedback) {
		feedbackService.add(feedback);
		pushNotificationService.broadcast(new Message("feedback", feedback.getOrderId().toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Delivery Feedback given");
											  put("userId", feedback.getUserId());
											  put("orderId", feedback.getOrderId());}};
	}
	
	@GetMapping("/feedback/user/{userId}")
	public List<Feedback> getByUserId(@PathVariable String userId) throws ObjectNotFoundException {
		return feedbackService.getByUserId(userId);
	}
	
	@GetMapping("/feedback/order/{orderId}")
	public List<Feedback> getByOrderId(@PathVariable Long orderId) throws ObjectNotFoundException {
		return feedbackService.getByOrderId(orderId);
	}
}
