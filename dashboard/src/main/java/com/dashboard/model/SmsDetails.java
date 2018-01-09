package com.dashboard.model;

import java.util.List;

public class SmsDetails {

	private String message;
	private List<String> to;
	
	public SmsDetails(String message, List<String> to) {
		super();
		this.message = message;
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getTo() {
		return to;
	}
	
	
}
