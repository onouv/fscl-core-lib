package org.fscl.core.domain.events;

import java.util.List;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;

@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class FsclEntityEvent<T extends FsclEntityEvent<T>> {
    protected FsclEntityId id;
    protected String name;
    protected String description;
    protected T parent;
    protected List<Parameter> parameters;
}
