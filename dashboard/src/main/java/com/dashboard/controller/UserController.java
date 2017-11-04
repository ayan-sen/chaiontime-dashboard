package com.dashboard.controller;

import java.util.List;
import java.util.Map;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.User;
import com.dashboard.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;
	
	@PutMapping("/user")
	public String add(@RequestBody User user) {
		return userService.add(user);
	}
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/user/{id:.+}")
	public User getById(@PathVariable String id) throws ObjectNotFoundException {
		return userService.getById(id);
	}
	
	@PatchMapping("/user")
	public String updateById(@RequestBody User user) throws ObjectNotFoundException {
		return userService.updateById(user);
	}
	
	@DeleteMapping("/user/{id:.+}")
	public String deleteById(@PathVariable String id) throws ObjectNotFoundException {
		return userService.deleteById(id);
	}
	
}
