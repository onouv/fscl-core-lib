package org.fscl.core.domain.entity.id;

public abstract class IdentifierMismatchException extends Exception {
    protected IdentifierMismatchException(String msg) {
        super(msg);
    }
}
