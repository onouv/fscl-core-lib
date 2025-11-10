package org.fscl.core.adapters.messaging;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.ResourceId;
import org.fscl.core.ports.driving.messaging.FunctionCreatedEventDto;

import com.fasterxml.jackson.databind.JsonNode;

public class FunctionCreatedMessage extends FunctionMessage {

	public FunctionCreatedMessage(ResourceId aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}

	@Override
	public String getType() {
		return EntityEventType.Created.toString();
	}

	public static FunctionCreatedMessage of(FunctionCreatedEventDto dto) {
		return null;
	}
}
