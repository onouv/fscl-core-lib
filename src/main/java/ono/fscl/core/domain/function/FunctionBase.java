package ono.fscl.core.domain.function;

import lombok.Getter;
import ono.fscl.core.domain.entity.Entity;
import ono.fscl.core.domain.entity.id.EntityId;

@Getter
public abstract class FunctionBase extends Entity<FunctionCode, FunctionBase> {
    
    public FunctionBase(EntityId<FunctionCode> id, FunctionBase parent, String name, String description) {
        super(id, parent, name, description);
    }

}
