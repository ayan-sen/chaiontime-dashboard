package com.dashboard.model;

public class Message {

	private String entityType;
	private String entityId;
	private Action action;
	
	public Message() {
		super();
	}

	public Message(String entityType, String entityId, Action action) {
		super();
		this.entityType = entityType;
		this.entityId = entityId;
		this.action = action;
	}

	public String getEntityType() {
		return entityType;
	}

	public String getEntityId() {
		return entityId;
	}

	public Action getAction() {
		return action;
	}
}
