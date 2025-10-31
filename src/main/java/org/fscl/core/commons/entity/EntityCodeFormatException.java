package org.fscl.core.commons.entity;

import org.fscl.core.domain.entity.EntityException;

public class EntityCodeFormatException extends EntityException {

	private static final long serialVersionUID = -3174003253501859076L;

	public EntityCodeFormatException(String message) {
		super(message);
	}

	public EntityCodeFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}
