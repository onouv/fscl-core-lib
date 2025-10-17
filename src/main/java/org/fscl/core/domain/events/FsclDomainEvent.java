package org.fscl.core.domain.events;


import lombok.EqualsAndHashCode;

/**
 * The root class for all domain events of a given domain.
 */
@EqualsAndHashCode
public abstract class FsclDomainEvent {
	
	public String viewName;
	
	protected FsclDomainEvent(String viewName) {
		this.viewName = new String(viewName);
	}
	
	/*
	 * @return the name of any derived class as the event type 
	 */
	public String getEventType() {
		return this.getClass().getSimpleName();
	}
	
	/*
	 * @return the name of the view
	 */
	public String getViewName() {
		return new String(this.viewName);
	}
}
