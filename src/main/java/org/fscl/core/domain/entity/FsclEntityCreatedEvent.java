package org.fscl.core.domain.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class FsclEntityCreatedEvent<T extends FsclEntity<T>> extends FsclEntityEvent<T> {
	
    protected FsclEntityCreatedEvent(String view, T entity) {
    	super(view, entity);
    }
}
