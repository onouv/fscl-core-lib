package ono.fscl.core.domain.entity.id;

public class PrefixMismatchException extends Exception {
    public PrefixMismatchException(String actual, String expected) {
        super(actual != null
                ? String.format("no expected value '%s' for prefix found", expected)
                : String.format("prefix '%s' not matching expected value '%s'", actual, expected));
    }
}
