package com.dashboard.service;

import javax.annotation.Resource;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.dashboard.model.Message;

@Service
public class PushNotificationService {

	@Resource
    private SimpMessagingTemplate template;
	
	
	public void broadcast(Message message) {
		template.convertAndSend("/broadcast/events/chaiontime", message);
	}
}
