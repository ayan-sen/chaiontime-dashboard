package com.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

		
	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","CRUD Example");
		return "index";
	}

		
}
