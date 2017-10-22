package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.dashboard.model.User;
import com.dashboard.repository.UserRepository;


@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	public String add(User user) {
		return userRepository.add(user);
	}

	public List<User> getAll() {
		List<User> users = userRepository.getAll();
		return users;
	}

	public User getById(String id) throws ObjectNotFoundException {
		User user = userRepository.getById(id);
		if(user == null) {
			throw new ObjectNotFoundException("User is not found for id :" + id);
		}
		return user;
	}

	public String updateById(User user) throws ObjectNotFoundException {
		if(StringUtils.isEmpty(user.getPassword())) {
			User oldUser = this.getById(user.getUseId());
			user.setPassword(oldUser.getPassword());
		}
		return userRepository.updateById(user);
	}

	public String deleteById(String id) throws ObjectNotFoundException {
		User user = this.getById(id);
		return userRepository.deleteById(user);
	}
	
}
