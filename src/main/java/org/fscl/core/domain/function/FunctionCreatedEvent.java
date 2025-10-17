package org.fscl.core.domain.function;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.bytebuddy.asm.Advice.This;

import org.fscl.core.domain.entity.FsclEntityCreatedEvent;

@EqualsAndHashCode(callSuper = true)
@Value
public class FunctionCreatedEvent extends FsclEntityCreatedEvent<FsclFunction> {

    public FunctionCreatedEvent(FsclFunction function) {
    	super("function", function);
    }   
}
