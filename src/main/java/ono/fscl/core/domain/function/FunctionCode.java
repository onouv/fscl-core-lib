package ono.fscl.core.domain.function;

import java.util.Arrays;
import java.util.List;

import ono.fscl.core.domain.entity.id.*;

public final class FunctionCode extends FsclEntityCode {

    public static class Builder extends FsclEntityCode.Builder<FunctionCode>{

        public Builder(String segmentSeparator) {
            super(segmentSeparator);
        }
        @Override
        public FunctionCode build() {
            return new FunctionCode(prefix(), postfix(), this.segms);
        }

        @Override
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

    public static Builder builder() {
        return new Builder(SEPARATOR);
    }

    public static final String PREFIX = "=";
    public static final String SEPARATOR = ".";
    
    private FunctionCode(String prefix, String postfix, List<String> segments) {
            super(prefix, postfix, segments, SEPARATOR);
    }
}
