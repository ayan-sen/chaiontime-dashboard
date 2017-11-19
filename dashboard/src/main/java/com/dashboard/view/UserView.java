package com.dashboard.view;

import java.util.List;

import com.dashboard.model.User;
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

	public Long getPhone() {
		return user.getPhone();
	}

	public String getAddressLine1() {
		return user.getAddressLine1();
	}

	public String getAddressLine2() {
		return user.getAddressLine2();
	}

	public String getCity() {
		return user.getCity();
	}

	public String getState() {
		return user.getState();
	}

	public String getPincode() {
		return user.getPincode();
	}

	public String getCountry() {
		return user.getCountry();
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
}
