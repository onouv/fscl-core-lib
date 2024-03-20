package ono.fscl.core.domain.entity.id;

public class PostfixMismatchException extends Exception {
    public PostfixMismatchException(String actual, String expected) {
        super(String.format("postfix '%s' not matching expected value '%s'", actual, expected));
    }
}
