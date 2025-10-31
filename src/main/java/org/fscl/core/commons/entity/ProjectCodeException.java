package org.fscl.core.commons.entity;

public class ProjectCodeException extends Exception {
	private static final long serialVersionUID = -2311344864634681896L;

	protected ProjectCodeException(String msg) {
		super(msg);
	}

	protected ProjectCodeException(String msg, Throwable root) {
		super(msg, root);
	}
}
