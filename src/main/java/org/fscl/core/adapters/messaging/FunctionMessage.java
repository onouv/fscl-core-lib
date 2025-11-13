package org.fscl.core.adapters.messaging;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class FunctionMessage extends FsclMessage {

	public FunctionMessage(String aggregateId, JsonNode payload) {
		super(aggregateId, payload);
	}

	@Override
	public String getAggregateType() {
		return "Function";
	}
}
