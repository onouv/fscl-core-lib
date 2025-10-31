package org.fscl.core.ports.driving.messaging;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.FsclEntityData;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class FunctionEventDto extends FsclEntityData {

	public abstract EntityEventType getEventType();
}
