package org.fscl.core.domain.function;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.bytebuddy.asm.Advice.This;

import org.fscl.core.domain.entity.FsclEntityCreatedEvent;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionCreatedEvent extends FsclEntityCreatedEvent<FsclFunction> {

    public FunctionCreatedEvent(FsclFunction function) {
    	super(function);
    }

    @Override
    public String getAggregateType() {
        return "Function";
    }

    @Override
    public String getType() {
        return "FunctionCreated";
    }

    public String toString() {
        return "{ id: " + this.getAggregateId() + ", function: " + this.payload.toString() + "timestamp: " + this.timestamp.toString() + " }";
    }

}
