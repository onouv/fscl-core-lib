package org.fscl.core.adapters.messaging;

import java.time.Instant;

import org.fscl.core.commons.entity.ResourceId;

import com.fasterxml.jackson.databind.JsonNode;

import io.debezium.outbox.quarkus.ExportedEvent;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public abstract class FsclMessage implements ExportedEvent<ResourceId, JsonNode> {
	
	@Getter(AccessLevel.NONE)
	private final ResourceId aggregateId;
	
	@Getter(AccessLevel.NONE)
    private final Instant timestamp;
	
	@Getter(AccessLevel.NONE)
    private final JsonNode payload;

	public FsclMessage(ResourceId aggregateId, JsonNode payload) {
		this.aggregateId = aggregateId;     
		this.timestamp = Instant.now();
        this.payload = payload;
	}
	
	@Override
	public ResourceId getAggregateId() {
		return this.aggregateId;
	}
	
	@Override
	public Instant getTimestamp() {
		return timestamp;
	}

	@Override
	public JsonNode getPayload() {
		return payload;
	}

}
