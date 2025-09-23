package org.fscl.core.domain.entity;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.events.FsclDomainEvent;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;

@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class FsclEntityEvent<T extends FsclEntity<T>> extends FsclDomainEvent {
    protected FsclEntityId id;
    protected String name;
    protected String description;
}
