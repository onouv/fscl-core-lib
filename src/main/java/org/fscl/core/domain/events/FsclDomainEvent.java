package org.fscl.core.domain.events;

import com.fasterxml.jackson.databind.JsonNode;

import io.debezium.outbox.quarkus.ExportedEvent;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class FsclDomainEvent implements ExportedEvent<String, JsonNode> {}
