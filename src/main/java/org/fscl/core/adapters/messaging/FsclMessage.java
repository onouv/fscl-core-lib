package org.fscl.core.adapters.messaging;

import java.time.Instant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.debezium.outbox.quarkus.ExportedEvent;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
public abstract class FsclMessage implements ExportedEvent<String, JsonNode> {

	@Getter(AccessLevel.NONE)
	private String aggregateId;

	@Getter(AccessLevel.NONE)
	private final Instant timestamp;

	@Getter(AccessLevel.NONE)
	private final JsonNode payload;

	final static ObjectMapper mapper = new ObjectMapper();

	public FsclMessage(String aggregateId, JsonNode payload) {
		this.aggregateId = aggregateId;
		this.timestamp = Instant.now();
		this.payload = payload;
	}

	@Override
	public String getAggregateId() {
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
