package org.fscl.shadow.domain.function;

import lombok.experimental.SuperBuilder;
import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.function.FunctionBase;

@SuperBuilder
public class ShadowFunction extends FunctionBase {

    private ShadowFunction(
        FsclEntityId id,
        String name,
        ShadowFunction parent,
        String description) {
            super( id, parent, name, description);
    }

}
