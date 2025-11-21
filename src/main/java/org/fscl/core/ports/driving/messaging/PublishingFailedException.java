package org.fscl.core.ports.driving.messaging;

public class PublishingFailedException extends MessagingException {

	private static final long serialVersionUID = 4425169557961112643L;

	public PublishingFailedException(String msg) {
		super(msg);
	}

}
