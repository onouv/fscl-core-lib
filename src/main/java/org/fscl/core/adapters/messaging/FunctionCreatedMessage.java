package org.fscl.core.adapters.messaging;

import org.fscl.core.commons.ResourceEventType;
import org.fscl.core.commons.ResourceId;
import org.fscl.core.ports.driving.messaging.FunctionCreatedEventDto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FunctionCreatedMessage extends FunctionMessage {

	public FunctionCreatedMessage(String aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}

	@Override
	public String getType() {
		return ResourceEventType.Created.toString();
	}

	public static FunctionCreatedMessage of(FunctionCreatedEventDto dto) {

		final ResourceId id = dto.getEntityId();
		final ObjectNode idNode = mapper.createObjectNode().put("project", id.getProject()).put("code", id.getCode());

		final ObjectNode payload = mapper.createObjectNode().set("resourceId", idNode);

		payload.put("name", dto.getName()).put("description", dto.getDescription());

		return new FunctionCreatedMessage(id.toString(), payload);
	}
}
