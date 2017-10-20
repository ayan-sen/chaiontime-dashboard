package com.dashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

		
	@RequestMapping("/hello")
    public String index() {
		
		
        return "test file";
        
        
    }
	
}
