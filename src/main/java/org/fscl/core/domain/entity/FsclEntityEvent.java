package org.fscl.core.domain.entity;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.events.FsclDomainEvent;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public abstract class FsclEntityEvent<T extends FsclEntity<T>> extends FsclDomainEvent {
	
	protected FsclEntity<T> entity;
	
	protected FsclEntityEvent(String view, FsclEntity<T> entity) {
		super(view);
		this.entity = entity;
	}    
}
