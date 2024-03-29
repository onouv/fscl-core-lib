package org.fscl.core.domain.entity.id;

public class EntityCodeException extends Exception {
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
