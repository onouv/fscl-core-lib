package ono.fscl.core.domain.function;

import lombok.Getter;
import ono.fscl.core.domain.entity.FsclEntity;
import ono.fscl.core.domain.entity.id.FsclEntityId;
import ono.fscl.shadow.domain.function.ShadowFunction;

@Getter
public abstract class FunctionBase extends FsclEntity<FunctionCode, FunctionBase> {
    
    public FunctionBase(FsclEntityId<FunctionCode> id, FunctionBase parent, String name, String description) {
        super(id, parent, name, description);
    }

    public abstract FsclEntityId<FunctionCode> getIdentifier();


    public static abstract class Builder<T extends FunctionBase> {

        public abstract T build();

        protected FsclEntityId<FunctionCode> identifier = null;
        protected T parent = null;
        protected String name = "";
        protected String description = "";

        public Builder<T> withIdentifier(FunctionCode code, String project) {
            this.identifier = new FsclEntityId<FunctionCode>(code, project);
            return this;
        }

        public Builder<T> withParent(T parent) {
            this.parent = parent;
            return this;
        }

        public Builder<T> withName(String name) {
            this.name = name;
            return this;
        }

        public Builder<T> withDescription(String description) {
            this.description = description;
            return this;
        }

    }

}
