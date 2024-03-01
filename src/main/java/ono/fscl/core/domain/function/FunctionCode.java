package ono.fscl.core.domain.function;

import java.util.List;
import java.util.regex.PatternSyntaxException;

import ono.fscl.core.domain.entity.id.FsclEntityCode;
import ono.fscl.core.domain.entity.id.SegmentFormatException;

public final class FunctionCode extends FsclEntityCode {

    public static class Builder extends FsclEntityCode.Builder<FunctionCode>{
        @Override
        public FunctionCode build() throws SegmentFormatException {
            String prefix = this.isShadow ? "(" + PREFIX : PREFIX;
            String postfix = this.isShadow ? ")" : null;

            try {
                return new FunctionCode(prefix, postfix, this.segms);
            } catch (PatternSyntaxException e) {
                throw new RuntimeException("Software error: ill-formed regexp-matching pattern");
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final String PREFIX = "=";
    public static final String SEPARATOR = ".";
    
    private FunctionCode(String prefix, String postfix, List<String> segments) throws SegmentFormatException, PatternSyntaxException {
            super(prefix, postfix, segments, SEPARATOR);
    }


}
