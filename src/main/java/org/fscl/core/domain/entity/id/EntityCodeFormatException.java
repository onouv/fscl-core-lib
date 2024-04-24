package org.fscl.core.domain.entity.id;

import org.fscl.core.domain.entity.EntityException;

public class EntityCodeFormatException extends EntityException {

    public EntityCodeFormatException(String message) {
        super(message);
    }

    public EntityCodeFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
