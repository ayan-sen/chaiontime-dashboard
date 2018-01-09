package com.dashboard.model;

import java.util.List;

public class Sms {

	private String sender;
	private String route;
	private String country;
	private List<SmsDetails> sms;
	
	public Sms(List<SmsDetails> sms) {
		super();
		this.sender = "SOCKET";
		this.route = "4";
		this.country = "91";
		this.sms = sms;
	}

	public String getSender() {
		return sender;
	}

	public String getRoute() {
		return route;
	}

	public String getCountry() {
		return country;
	}

	public List<SmsDetails> getSms() {
		return sms;
	}
}
