package org.fscl.core.domain.resource;

public abstract class ResourceException extends Exception {
    protected ResourceException() {
        super();
    }

    protected ResourceException(String message) {

        super(message);
    }
    protected ResourceException(Throwable cause) {

        super(cause);
    }

    protected ResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
