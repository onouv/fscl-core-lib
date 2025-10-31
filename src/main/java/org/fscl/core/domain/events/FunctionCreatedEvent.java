package org.fscl.core.domain.events;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.EntityType;
import org.fscl.core.domain.entity.FsclFunction;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionCreatedEvent extends FsclEntityEvent<FsclFunction> {

    public FunctionCreatedEvent(String viewName, FsclFunction function) {
    	super(viewName, function);
    }
    
    @Override
    public EntityEventType getEventType() {
    	return EntityEventType.Created;
    }
    
    @Override
    public EntityType getEntityType() {
    	return EntityType.Function;
    }
}
