package org.fscl.core.adapters.messaging;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.ports.driving.messaging.FunctionDeletedEventDto;

import com.fasterxml.jackson.databind.JsonNode;

public class FunctionDeletedMessage extends FunctionMessage {

	public FunctionDeletedMessage(String aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}

	@Override
	public String getType() {
		return ResourceEventType.Deleted.toString();
	}

	public static FunctionDeletedMessage of(FunctionDeletedEventDto dto) {
		return null;
	}

}
