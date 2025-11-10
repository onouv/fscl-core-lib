package org.fscl.core.adapters.messaging;


import org.fscl.core.commons.entity.ResourceId;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class FunctionMessage extends FsclMessage {
	
	final static ObjectMapper mapper = new ObjectMapper();
	
	public FunctionMessage(ResourceId aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}
	
	@Override
	public String getAggregateType() {
		return "Function";
	}
}
