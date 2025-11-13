package org.fscl.core.domain.events;

import org.fscl.core.commons.ResourceData;
import org.fscl.core.domain.resource.Resource;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class ResourceEvent<T extends Resource<T>> extends FsclDomainEvent {

	protected ResourceData entity;

	protected ResourceEvent(String view, Resource<T> entity) {
		super(view);
		this.entity = entity;
	}
}
