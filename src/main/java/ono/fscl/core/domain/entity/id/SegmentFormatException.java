package ono.fscl.core.domain.entity.id;

public class SegmentFormatException extends Exception {
    protected final String group;

    public SegmentFormatException(String group) {
        super();
        this.group = group;
    }

    @Override
    public String getMessage() {
        return "Format of group string not valid: " + this.group;
    }
}
