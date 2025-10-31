package org.fscl.core.commons.entity;

public class EntityCodeException extends Exception {
    private static final long serialVersionUID = 1599786622441187716L;
	String entityCode;

    protected EntityCodeException(String code, String message) {
        super(message);
        this.entityCode = code;
    }

    protected EntityCodeException(String code, String message, Throwable root) {
        super(message, root);
        this.entityCode = code;
    }
}
