package org.fscl.core.domain.entity.id;

public class EntityCodeFormatException extends Exception {

    public EntityCodeFormatException(String message) {
        super(message);
    }

    public EntityCodeFormatException(String message, Throwable root) {
        super(message, root);
    }
}
