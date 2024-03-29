package org.fscl.core.domain.function;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public abstract class FunctionBase extends FsclEntity<FunctionBase> {
    
    public FunctionBase(FsclEntityId id, FunctionBase parent, String name, String description) {
        super(id, parent, name, description);
    }


    /*
    public static abstract class Builder<T extends FunctionBase> {

        public abstract T build();

        protected FsclEntityId identifier = null;
        protected T parent = null;
        protected String name = "";
        protected String description = "";

        public Builder<T> withIdentifier(String code, String project) {
            this.identifier = new FsclEntityId(code, project);
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
     */

}
