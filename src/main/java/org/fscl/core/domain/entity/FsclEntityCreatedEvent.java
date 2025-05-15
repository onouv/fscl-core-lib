package org.fscl.core.domain.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class FsclEntityCreatedEvent<T extends FsclEntity<T>> extends FsclEntityEvent<T> {
    protected T parent;
}
