package org.fscl.core.domain.entity.id;

public class PostfixMismatchException extends IdentifierMismatchException {
    public PostfixMismatchException(String actual, String expected) {
        super(String.format("postfix '%s' not matching expected value '%s'", actual, expected));
    }
}
