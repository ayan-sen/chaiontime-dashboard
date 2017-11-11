package com.dashboard.controller;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.service.UserService;
import com.dashboard.view.UserView;

@RestController
public class DashboardController {

	@Resource
	private UserService userService;
	
	@PostMapping("/login")
	public UserView getuserinfo() throws ObjectNotFoundException {
		return new UserView(userService.getById(SecurityContextHolder.getContext().getAuthentication().getName()));
	}

	
	@GetMapping("/loginfail")
	public void throwLoginFailedMessage() throws LoginException {
		throw new LoginException("Invalid User Name/password");
	}	
}
