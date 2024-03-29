package org.fscl.core.domain.system;

import org.fscl.core.domain.entity.id.FsclEntityCode;
import org.fscl.core.domain.entity.id.PostfixMismatchException;
import org.fscl.core.domain.entity.id.PrefixMismatchException;

import java.util.Arrays;
import java.util.List;

public final class SystemCode extends FsclEntityCode {
    public static final String PREFIX = "#";
    public static final String SEPARATOR = ".";

    public static class Builder extends FsclEntityCode.Builder<SystemCode>{

        public Builder(String segmentSeparator) {
            super(segmentSeparator);
        }
        @Override
        public SystemCode build() {
            return new SystemCode(prefix(), postfix(), this.segms);
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

    public static SystemCode.Builder builder() {
        return new SystemCode.Builder(SEPARATOR);
    }

    public SystemCode(String prefix, String postfix, List<String> segments) {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
