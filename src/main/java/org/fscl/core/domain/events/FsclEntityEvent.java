package org.fscl.core.domain.events;

import org.fscl.core.commons.entity.FsclEntityData;
import org.fscl.core.domain.entity.FsclEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public abstract class FsclEntityEvent<T extends FsclEntity<T>> extends FsclDomainEvent {

	protected FsclEntityData entity;

	protected FsclEntityEvent(String view, FsclEntity<T> entity) {
		super(view);
		this.entity = entity;
	}
}
