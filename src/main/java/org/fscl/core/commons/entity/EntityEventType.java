package org.fscl.core.commons.entity;

public enum EntityEventType {
	Created("Created"),
	Deleted("Deleted");
	
	private final String value;
	
	EntityEventType(String value) {
		this.value = value;
	}
}
