package org.fscl.core.commons;

import org.fscl.core.domain.resource.ResourceException;

public class ResourceCodeFormatException extends ResourceException {

	private static final long serialVersionUID = -3174003253501859076L;

	public ResourceCodeFormatException(String message) {
		super(message);
	}

	public ResourceCodeFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}
