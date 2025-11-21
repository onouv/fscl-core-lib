package org.fscl.core.application.messaging;

import org.fscl.core.commons.ResourceData;
import org.fscl.core.commons.ResourceId;
import org.fscl.core.commons.ResourceType;
import org.fscl.core.domain.events.FsclDomainEvent;
import org.fscl.core.domain.events.FunctionCreatedEvent;
import org.fscl.core.domain.resource.FunctionResource;
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
		if (event.getEntityType() != ResourceType.Function) {
			throw new DtoMappingFailedException("Cannot outwards-map event as function dto.");
		}

		switch (event.getEventType()) {
			case Created:
				ResourceData entity = ((FunctionCreatedEvent) event).getEntity();
				return FunctionCreatedEventDto.builder()
					.resourceId(entity.getResourceId())
					.name(entity.getName())
					.description(entity.getDescription())
					.build();
			case Deleted:
				// break;
			default:
				throw new DtoMappingFailedException("Cannot outwards-map event due to unknown event type.");
		}
	}

	protected JsonNode makePayload(ResourceId id, FsclDomainEvent event, FunctionResource entity) {
		ObjectNode aggregateId = this.mapper.createObjectNode()
			.put("project", id.getProject())
			.put("code", id.getCode());

		return ((ObjectNode) this.mapper.createObjectNode().set("aggregateId", aggregateId))
			.put("viewName", event.getViewName())
			.put("name", entity.getName())
			.put("description", entity.getDescription());

	}
}
