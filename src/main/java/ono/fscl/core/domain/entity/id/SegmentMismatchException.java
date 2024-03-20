package ono.fscl.core.domain.entity.id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SegmentMismatchException extends Exception {
    protected final String segment;


    @Override
    public String getMessage() {
        return "Format of segment not valid: " + this.segment;
    }
}
