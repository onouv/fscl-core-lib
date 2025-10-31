package org.fscl.core.application.messaging;

import org.fscl.core.commons.entity.EntityType;
import org.fscl.core.commons.entity.FsclEntityData;
import org.fscl.core.commons.entity.FsclEntityId;
import org.fscl.core.domain.entity.FsclFunction;
import org.fscl.core.domain.events.FsclDomainEvent;
import org.fscl.core.domain.events.FunctionCreatedEvent;
import org.fscl.core.ports.driving.messaging.DtoMappingFailedException;
import org.fscl.core.ports.driving.messaging.FunctionCreatedEventDto;
import org.fscl.core.ports.driving.messaging.FunctionEventDto;
import org.fscl.core.ports.driving.messaging.MessagingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FunctionEventMapper {

	private final ObjectMapper mapper = new ObjectMapper();

	public FunctionEventDto outwards(FsclDomainEvent event) throws MessagingException {
		if (event.getEntityType() != EntityType.Function) {
			throw new DtoMappingFailedException("Cannot outwards-map event as function dto.");
		}

		switch (event.getEventType()) {
			case Created:
				FsclEntityData entity = ((FunctionCreatedEvent) event).getEntity();
				return FunctionCreatedEventDto.builder().entityId(entity.getEntityId()).name(entity.getName())
						.description(entity.getDescription()).build();
			case Deleted:
				// break;
			default:
				throw new DtoMappingFailedException("Cannot outwards-map event due to unknown event type.");
		}
	}

	protected JsonNode makePayload(FsclEntityId id, FsclDomainEvent event, FsclFunction entity) {
		ObjectNode aggregateId = this.mapper.createObjectNode().put("project", id.project()).put("code", id.code());

		return ((ObjectNode) this.mapper.createObjectNode().set("aggregateId", aggregateId))
				.put("viewName", event.getViewName()).put("name", entity.getName())
				.put("description", entity.getDescription());

	}
}
