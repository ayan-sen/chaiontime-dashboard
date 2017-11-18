package com.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Message;

@RestController
public class WebSocketController {

	private static final Logger logger = Logger.getLogger(WebSocketController.class);
	
	@GetMapping("/connect")
	@ResponseBody
	public Map<String, String> connect() {
		return new HashMap<String, String>(){{
			put("message", "CONNECTED");
		}};
	}
	
	
	@MessageMapping("/dashboard")
    @SendTo("/broadcast/events/chaiontime")
    public Message message(Message message) throws Exception {
		logger.info("Received message: " + message);
        return message;
    }
}
