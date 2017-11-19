package com.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.Action;
import com.dashboard.model.Message;
import com.dashboard.model.User;
import com.dashboard.service.PushNotificationService;
import com.dashboard.service.UserService;
import com.dashboard.view.UserView;

@RestController
public class UserController {

	@Resource
	private UserService userService;
	
	@Resource
	private PushNotificationService pushNotificationService;
	
	@PutMapping("/user")
	public Map<String, Object> add(@RequestBody User user) {
		String id = userService.add(user);
		pushNotificationService.broadcast(new Message("user", id.toString(), Action.CREATED));
		return new HashMap<String, Object>(){{put("message", "User Added");put("id", id);}};
	}
	
	@GetMapping("/users")
	public List<UserView> getAll() {
		return userService.getAll().stream().map(u -> new UserView(u)).collect(Collectors.toList());
	}
	
	@GetMapping("/user/{id:.+}")
	public UserView getById(@PathVariable String id) throws ObjectNotFoundException {
		return new UserView(userService.getById(id));
	}
	
	@PatchMapping("/user")
	public Map<String, Object> updateById(@RequestBody User user) throws ObjectNotFoundException {
		String userId = userService.updateById(user);
		pushNotificationService.broadcast(new Message("User", userId, Action.UPDATED));
		return new HashMap<String, Object>(){{put("message", "User updated");put("id", userId);}};
	}
	
	@DeleteMapping("/user/{id:.+}")
	public Map<String, Object> deleteById(@PathVariable String id) throws ObjectNotFoundException {
		userService.deleteById(id);
		pushNotificationService.broadcast(new Message("user", id.toString(), Action.DELETED));
		return new HashMap<String, Object>(){{put("message", "User Deleted");put("id", id);}};
	}
	
}
