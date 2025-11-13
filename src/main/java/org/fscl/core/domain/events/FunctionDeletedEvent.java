package org.fscl.core.domain.events;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.commons.ResourceType;
import org.fscl.core.domain.resource.FunctionResource;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionDeletedEvent extends ResourceEvent<FunctionResource> {

    public FunctionDeletedEvent(FunctionResource function) {
    	super("function", function);
    }
    
    @Override
    public ResourceEventType getEventType() {
    	return ResourceEventType.Deleted;
    }
    
    @Override
    public ResourceType getEntityType() {
    	return ResourceType.Function;
    }
}