package org.fscl.core.domain.entity.id;

public class SegmentMismatchException extends IdentifierMismatchException {
    protected final String segment;


    public SegmentMismatchException(String segment) {
        super()
        this.segment = segment;
    }

    @Override
    public String getMessage() {
        return "Format of segment not valid: " + this.segment;
    }
}
