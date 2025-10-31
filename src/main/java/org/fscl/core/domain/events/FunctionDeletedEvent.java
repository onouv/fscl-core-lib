package org.fscl.core.domain.events;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.EntityType;
import org.fscl.core.domain.entity.FsclFunction;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionDeletedEvent extends FsclEntityEvent<FsclFunction> {

    public FunctionDeletedEvent(FsclFunction function) {
    	super("function", function);
    }
    
    @Override
    public EntityEventType getEventType() {
    	return EntityEventType.Deleted;
    }
    
    @Override
    public EntityType getEntityType() {
    	return EntityType.Function;
    }
}