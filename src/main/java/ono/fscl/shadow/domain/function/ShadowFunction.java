package ono.fscl.shadow.domain.function;

import ono.fscl.core.domain.entity.id.FsclEntityId;
import ono.fscl.core.domain.function.FunctionBase;
import ono.fscl.core.domain.function.FunctionCode;
import org.axonframework.modelling.command.EntityId;

public class ShadowFunction extends FunctionBase {

    @Override
    @EntityId
    public FsclEntityId<FunctionCode> getIdentifier() {
        return this.identifier;
    }

    // INFO: @SuperBuilder does not work here because of the generic type parameters,
    // so we need to roll our own dice...
    public static ShadowFunction.Builder builder() {
        return new Builder();
    }

    public static class Builder extends FunctionBase.Builder<ShadowFunction> {

        @Override
        public ShadowFunction build() {
            return new ShadowFunction(this.identifier, this.name, this.parent, this.description);
        }
    }


    private ShadowFunction(
        FsclEntityId<FunctionCode> id,
        String name,
        ShadowFunction parent,
        String description) {
            super( id, parent, name, description);
    }

}
