package com.dashboard.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dashboard.model.User;
import com.dashboard.repository.UserRepository;

@Service
public class DashboardUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	private String userId;
	
	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		
			User activeUserInfo = userRepository.getById(userId);
			
			if(activeUserInfo == null) {
				throw new UsernameNotFoundException(userId + " is not found");
			}
			setUserId(userId);
			List<GrantedAuthority> auths = activeUserInfo.getUserRoles().stream().map(u -> new SimpleGrantedAuthority(u.getRole())).collect(Collectors.toList());	
			UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(activeUserInfo.getUserId(),
					activeUserInfo.getPassword(), auths);
			return userDetails;
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
