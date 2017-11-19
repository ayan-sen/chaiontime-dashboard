package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Faq;
import com.dashboard.model.Message;
import com.dashboard.model.TermsAndCondition;
import com.dashboard.service.PushNotificationService;
import com.dashboard.service.TermsAndConditionService;

@RestController
public class TermsAndConditionController {

	@Resource
	private TermsAndConditionService termsAndConditionService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/terms")
	public Map<String, Object> add(@RequestBody TermsAndCondition termsAndCondition) {
		Long id = termsAndConditionService.add(termsAndCondition);
		pushNotificationService.broadcast(new Message("ternmsandconditions", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Terms and Conditions Added");
											  put("id", id.toString());}};
	}
	
	@GetMapping("/terms")
	public List<TermsAndCondition> getAll() {
		return termsAndConditionService.getAll();
	}
	
	@DeleteMapping("/terms/{id}")
	public Map<String, Object> deleteById(@PathVariable Long id) {
		termsAndConditionService.deleteById(id);
		pushNotificationService.broadcast(new Message("ternmsandconditions", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "Terms and Conditions Deleted");
											  put("id", id);}};
	}
}
