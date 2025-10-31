package org.fscl.core.ports.driving.messaging;

import org.fscl.core.commons.entity.EntityEventType;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class FunctionDeletedEventDto extends FunctionEventDto {

	@Override
	public EntityEventType getEventType() {

		return EntityEventType.Deleted;
	}

}
