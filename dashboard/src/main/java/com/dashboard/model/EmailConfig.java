package com.dashboard.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailConfig {

	private List<String> to;
	private List<String> cc;
	private List<String> bcc;
	private String subject;
	private String body;
	private Map<String , Object> model = new HashMap<>();
	
	public EmailConfig(List<String> to, List<String> cc, List<String> bcc,
			String subject, String body) {
		super();
		this.to = to;
		this.cc = cc==null?new ArrayList<String>():cc;
		this.bcc = bcc==null?new ArrayList<String>():bcc;
		this.subject = subject;
		this.body = body;
	}
	
	public EmailConfig(List<String> to, List<String> cc, List<String> bcc,
			String subject, String body, Map<String , Object> model) {
		super();
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
		this.model = model;
	}

	public List<String> getTo() {
		return to;
	}

	public List<String> getCc() {
		return cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public Map<String, Object> getModel() {
		return model;
	}
	
}
