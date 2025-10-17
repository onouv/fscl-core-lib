package org.fscl.core.ports.messaging;

public record FsclDomainEventDto(
	String viewName,
	String project,
	String code,
	String name,
	String decription) {};

