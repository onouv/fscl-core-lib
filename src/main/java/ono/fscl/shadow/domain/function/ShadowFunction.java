package ono.fscl.shadow.domain.function;

import ono.fscl.core.domain.entity.id.EntityId;
import ono.fscl.core.domain.function.FunctionBase;
import ono.fscl.core.domain.function.FunctionCode;

public class ShadowFunction extends FunctionBase {
    
    public static ShadowFunction.Builder builder() {
        return new Builder();
    }

    // INFO: @SuperBuilder does not work here because of the generic type parameters
    // so we need to roll our own dice...

    public static class Builder {
        private EntityId<FunctionCode> identifier = null;
        private ShadowFunction parent = null;
        private String name = "";
        private String description = "";

        public Builder identifier(FunctionCode code, String project) {
            this.identifier = new EntityId<FunctionCode>(code, project);
            return this;
        }

        public Builder parent(ShadowFunction parent) {
            this.parent = parent;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ShadowFunction build() {
            return new ShadowFunction(
                this.identifier,
                this.name,
                this.parent,
                this.description);
        }
    }

    private ShadowFunction(
        EntityId<FunctionCode> id,
        String name,
        ShadowFunction parent,
        String desciption) {
            super( id, parent, name, desciption);
    }

}
