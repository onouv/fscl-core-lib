package org.fscl.core.domain.events;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.commons.ResourceType;
import org.fscl.core.domain.resource.FunctionResource;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionCreatedEvent extends ResourceEvent<FunctionResource> {

    public FunctionCreatedEvent(String viewName, FunctionResource function) {
    	super(viewName, function);
    }
    
    @Override
    public ResourceEventType getEventType() {
    	return ResourceEventType.Created;
    }
    
    @Override
    public ResourceType getEntityType() {
    	return ResourceType.Function;
    }
}
