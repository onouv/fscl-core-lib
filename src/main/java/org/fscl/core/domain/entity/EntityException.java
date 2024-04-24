package org.fscl.core.domain.entity;

public abstract class EntityException extends Exception {
    protected EntityException() {
        super();
    }

    protected EntityException(String message) {

        super(message);
    }
    protected EntityException(Throwable cause) {

        super(cause);
    }

    protected EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
