package org.fscl.core.domain.events;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import io.debezium.outbox.quarkus.ExportedEvent;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class FsclDomainEvent implements ExportedEvent<String, JsonNode> {
	protected final Instant timestamp = Instant.now();
	protected final static ObjectMapper mapper = new ObjectMapper();
	protected final ObjectNode payload = mapper.createObjectNode();
	
	@Override
    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public JsonNode getPayload() {
        return payload;
    }
}
