package org.fscl.core.adapters.messaging;

import org.fscl.core.commons.entity.EntityEventType;
import org.fscl.core.commons.entity.ResourceId;
import org.fscl.core.ports.driving.messaging.FunctionDeletedEventDto;

import com.fasterxml.jackson.databind.JsonNode;

public class FunctionDeletedMessage extends FunctionMessage {

	public FunctionDeletedMessage(ResourceId aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}

	@Override
	public String getType() {
		return EntityEventType.Deleted.toString();
	}

	public static FunctionDeletedMessage of(FunctionDeletedEventDto dto) {
		return null;
	}

}
