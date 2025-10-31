package org.fscl.core.ports.driving.messaging;

public interface FunctionMessagingPort {
	void publish(FunctionEventDto event) throws MessagingException;
}
