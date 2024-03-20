package ono.fscl.core.domain.component;

import ono.fscl.core.domain.entity.id.FsclEntityCode;
import ono.fscl.core.domain.entity.id.PostfixMismatchException;
import ono.fscl.core.domain.entity.id.PrefixMismatchException;
import ono.fscl.core.domain.entity.id.SegmentMismatchException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class ComponentCode extends FsclEntityCode {
    public static final String PREFIX = "-";
    public static final String SEPARATOR = ".";

    public static class Builder extends FsclEntityCode.Builder<ComponentCode>{

        public Builder(String segmentSeparator) {
            super(segmentSeparator);
        }
        @Override
        public ComponentCode build()  {
            return new ComponentCode(prefix(), postfix(), this.segms);
        }

        public Builder withCode(String code) throws
                PrefixMismatchException,
                PostfixMismatchException {
            if ( ! code.startsWith(prefix()) ) {
                throw new PrefixMismatchException(null, prefix());
            }

            if ( ! code.endsWith(postfix())) {
                throw new PostfixMismatchException(null, prefix());
            }

            String segmentStr = code.substring(prefix().length(), code.length() - postfix().length());
            String[] segments = segmentStr.split("/" + SEPARATOR);
            this.segms.addAll(Arrays.asList(segments));

            return this;
        }


        @Override
        protected String prefix() {
            return this.isShadow ? "(" + PREFIX : PREFIX;
        }

        @Override
        protected String postfix() {
            return this.isShadow ? ")" : "";
        }
    }

    public static ComponentCode.Builder builder() {
        return new ComponentCode.Builder(SEPARATOR);
    }

    public ComponentCode(String prefix, String postfix, List<String> segments) {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
