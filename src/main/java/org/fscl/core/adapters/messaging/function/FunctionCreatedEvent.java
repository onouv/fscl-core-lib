package org.fscl.core.adapters.messaging.function;

import org.fscl.core.adapters.messaging.FsclMessagedEvent;

public class FunctionCreatedEvent extends FsclMessagedEvent {
	
	@Override
    public String getAggregateType() {
        return "Function";
    }

    @Override
    public String getType() {
        return "FunctionCreated";
    }

}
