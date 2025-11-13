package org.fscl.core.commons;

public enum ResourceEventType {
	Created("Created"),
	Deleted("Deleted");
	
	private final String value;
	
	ResourceEventType(String value) {
		this.value = value;
	}
}
