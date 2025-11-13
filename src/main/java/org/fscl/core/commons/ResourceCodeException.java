package org.fscl.core.commons;

public class ResourceCodeException extends Exception {
    private static final long serialVersionUID = 1599786622441187716L;
	String entityCode;

    protected ResourceCodeException(String code, String message) {
        super(message);
        this.entityCode = code;
    }

    protected ResourceCodeException(String code, String message, Throwable root) {
        super(message, root);
        this.entityCode = code;
    }
}
