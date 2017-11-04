package com.dashboard.controller;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.User;
import com.dashboard.service.UserService;

@RestController
public class DashboardController {

	@Resource
	private UserService userService;
	
	@GetMapping("/userinfo")
	private User getuserinfo() throws ObjectNotFoundException {
		return userService.getById(SecurityContextHolder.getContext().getAuthentication().getName());
	}

		
}
