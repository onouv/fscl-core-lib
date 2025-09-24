package org.fscl.core.domain.entity;

import org.fscl.core.domain.entity.id.FsclEntityId;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class FsclEntityCreatedEvent<T extends FsclEntity<T>> extends FsclEntityEvent {
    protected FsclEntityCreatedEvent(T entity) {
    	super(entity.getEntityId(), entity.name, entity.description);
    	
    	FsclEntity<T> parent = entity.getParent();
    	
    	if (parent != null) {
    		
    		String project = parent.getProject();
    		String code = parent.getCode();
    		
    		super.payload.put("parentCode", code);
    		super.payload.put("parentProject", project);
    	}
    }
}
