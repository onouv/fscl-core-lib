package ono.fscl.core.domain.system;

import ono.fscl.core.domain.entity.id.FsclEntityCode;
import ono.fscl.core.domain.entity.id.SegmentFormatException;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class SystemCode extends FsclEntityCode {
    public static final String PREFIX = "#";
    public static final String SEPARATOR = ".";

    public static class Builder extends FsclEntityCode.Builder<SystemCode>{
        @Override
        public SystemCode build() throws SegmentFormatException {
            String prefix = this.isShadow ? "(" + PREFIX : PREFIX;
            String postfix = this.isShadow ? ")" : null;

            try {
                return new SystemCode(prefix, postfix, this.segms);
            } catch (PatternSyntaxException e) {
                throw new RuntimeException("Software error: ill-formed regexp-matching pattern");
            }
        }
    }

    public static SystemCode.Builder builder() {
        return new SystemCode.Builder();
    }

    public SystemCode(String prefix, String postfix, List<String> segments) throws SegmentFormatException, PatternSyntaxException {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
