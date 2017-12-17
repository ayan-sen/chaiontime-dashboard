package com.dashboard.view;

import java.util.List;

import com.dashboard.model.User;
import com.dashboard.model.UserAddress;
import com.dashboard.model.UserRole;

public class UserView {

	private User user;

	public UserView(User user) {
		super();
		this.user = user;
	}
	
	public String getUserId() {
		return user.getUserId();
	}
	
	public String getUserName() {
		return user.getUserName();
	}

	public String getEmail() {
		return user.getEmail();
	}

	public String getPhone() {
		return user.getPhone();
	}

	public Double getWalletAmount() {
		return user.getWalletAmount();
	}

	public Boolean isActive() {
		return user.isActive();
	}
	
	public List<UserRole> getUserRoles() {
		return user.getUserRoles();
	}
	
	public List<UserAddress> getUserAddress() {
		return user.getUserAddress();
	}
}
