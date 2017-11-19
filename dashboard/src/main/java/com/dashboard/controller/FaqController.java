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
import com.dashboard.service.FaqService;
import com.dashboard.service.PushNotificationService;

@RestController
public class FaqController {

	@Resource
	private FaqService faqService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/faq")
	public Map<String, Object> add(@RequestBody Faq faq) {
		Long id = faqService.add(faq);
		pushNotificationService.broadcast(new Message("feedback", faq.getId().toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "Faq Added");
											  put("id", faq.getId());}};
	}
	
	@GetMapping("/faq")
	public List<Faq> getAll() {
		return faqService.getAll();
	}
	
	@DeleteMapping("/faq/{id}")
	public Map<String, Object> deleteById(@PathVariable Long id) {
		faqService.deleteById(id);
		pushNotificationService.broadcast(new Message("feedback", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "Faq Deleted");
											  put("id", id);}};
	}

}
