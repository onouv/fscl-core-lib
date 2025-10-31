package org.fscl.core.domain.events;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.EntityType;

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

	public abstract EntityEventType getEventType();

	public abstract EntityType getEntityType();
}
