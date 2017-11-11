package com.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

	@GetMapping("/connect")
	public Map<String, String> connect() {
		return new HashMap<String, String>(){{
			put("message", "CONNECTED");
		}};
	}
}
