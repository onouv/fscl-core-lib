package org.fscl.core.ports.driving.messaging;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.commons.ResourceData;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class FunctionEventDto extends ResourceData {

	public abstract ResourceEventType getEventType();
}
