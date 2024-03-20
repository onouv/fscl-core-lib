package ono.fscl.core.domain.entity.id;

public class SeparatorMismatchException extends Exception {

    public SeparatorMismatchException(String actual, String expected) {
        super(actual != null
                ? String.format("no expected value '%s' for segment separator found", expected)
                : String.format("segment separator '%s' not matching expected value '%s'", actual, expected));
    }
}
