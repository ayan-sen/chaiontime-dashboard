package com.dashboard.security;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javassist.tools.rmi.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dashboard.model.User;
import com.dashboard.service.UserService;

@Service
public class DashboardUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		
		try {
			User activeUserInfo = userService.getById(userId);
		
			//GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getAccessRights());
			List<GrantedAuthority> auths = activeUserInfo.getUserRoles().stream().map(u -> new SimpleGrantedAuthority(u.getRole())).collect(Collectors.toList());	
			UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUserInfo.getUserName(),
					activeUserInfo.getPassword(), auths);
			return userDetails;
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
