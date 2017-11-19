package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;

public class FeedbackId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "ORDER_ID")
	private Long orderId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
