package org.fscl.core.domain.entity;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.events.FsclDomainEvent;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public abstract class FsclEntityEvent extends FsclDomainEvent {
	
    protected FsclEntityEvent(FsclEntityId id, String name, String description) {
    	super();
    	
    	super.payload.put("project", id.project());
    	super.payload.put("code", id.code());       
        super.payload.put("name", name);
        super.payload.put("description", description);
    }
    
    public String getAggregateId() {
        FsclEntityId id = new FsclEntityId(
        		super.payload.get("project").toString(),
        		super.payload.get("code").toString());
    	
        return id.toString();
    }
}
