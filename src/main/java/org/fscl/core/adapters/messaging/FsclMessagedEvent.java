package org.fscl.core.adapters.messaging;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import io.debezium.outbox.quarkus.ExportedEvent;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public abstract class FsclMessagedEvent implements ExportedEvent<String, JsonNode> {
	
	//
	// For meaning of these fields, refer to ExportedEvent  
	//
	private String aggregateId;
	private String aggregateType;
	
	@Getter(AccessLevel.NONE)
	private String eventType;
	
	protected final Instant timestamp = Instant.now();	
	protected final ObjectNode payload = mapper.createObjectNode();
	protected final static ObjectMapper mapper = new ObjectMapper();
	
	public FsclMessagedEvent(String aggregateId, String aggregateType, String eventType) {
		this.aggregateId = new String(aggregateId);
		this.aggregateType = new String(aggregateType);
		this.eventType = new String(eventType);
	}
	
	@Override
	public String getType() {
		return this.eventType;
	}
}


