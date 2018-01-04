package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.User;
import com.dashboard.model.UserAddress;
import com.dashboard.model.UserRole;
import com.dashboard.repository.UserRepository;


@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	//@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public String add(User user) {
		List<UserRole> userRoles = user.getUserRoles();
		if(!CollectionUtils.isEmpty(userRoles))
			userRoles.forEach(u -> u.setUser(user));
		List<UserAddress> userAddresses = user.getUserAddress();
		if(!CollectionUtils.isEmpty(userAddresses))
			userAddresses.forEach(u -> u.setUserAddress(user));
		return userRepository.add(user);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<User> getAll() {
		List<User> users = userRepository.getAll();
		return users;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public User getById(String id) throws ObjectNotFoundException {
		User user = userRepository.getById(id);
		if(user == null) {
			throw new ObjectNotFoundException("User is not found for id :" + id);
		}
		return user;
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public String updateById(User user) throws ObjectNotFoundException {
		if(StringUtils.isEmpty(user.getPassword())) {
			User oldUser = this.getById(user.getUserId());
			user.setPassword(oldUser.getPassword());
		}
		List<UserRole> userRoles = user.getUserRoles();
		if(!CollectionUtils.isEmpty(userRoles))
			userRoles.forEach(u -> u.setUser(user));
		
		List<UserAddress> userAddresses = user.getUserAddress();
		if(!CollectionUtils.isEmpty(userAddresses))
			userAddresses.forEach(u -> u.setUserAddress(user));
		
		return userRepository.updateById(user);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public String deleteById(String id) throws ObjectNotFoundException {
		User user = this.getById(id);
		return userRepository.deleteById(user);
	}
	
}
