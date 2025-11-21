package org.fscl.core.domain.events;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.commons.ResourceType;

import lombok.Getter;

/**
 * The root class for all domain events of a given domain.
 */
public abstract class FsclDomainEvent {

	@Getter
	protected String viewName;

	protected FsclDomainEvent(String viewName) {
		this.viewName = viewName;
	}

	public abstract ResourceEventType getEventType();

	public abstract ResourceType getEntityType();
}
