package org.fscl.core.ports.driving.messaging;

import org.fscl.core.commons.ResourceEventType;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class FunctionCreatedEventDto extends FunctionEventDto {

	@Override
	public ResourceEventType getEventType() {
		return ResourceEventType.Created;
	}

}
