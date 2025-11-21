package org.fscl.core.domain.parameter;

public class QuantityTypeException extends Exception {

	private static final long serialVersionUID = 2188768222517982751L;
	private static final String MSG = "Invalid quantity type";

	public QuantityTypeException() {
		super(MSG);
	}

	public QuantityTypeException(String message) {
		super(MSG + ": " + message);
	}
}
