package org.fscl.core.domain.location;

import org.fscl.core.domain.entity.id.FsclEntityCode;
import org.fscl.core.domain.entity.id.PostfixMismatchException;
import org.fscl.core.domain.entity.id.PrefixMismatchException;

import java.util.Arrays;
import java.util.List;

public final class LocationCode extends FsclEntityCode {
    public static final String PREFIX = "+";
    public static final String SEPARATOR = ".";
    public static class Builder extends FsclEntityCode.Builder<LocationCode>{

        public Builder(String segmentSeparator) {
            super(segmentSeparator);
        }
        @Override
        public LocationCode build()  {
            return new LocationCode(prefix(), postfix(), this.segms);
        }

        public Builder withCode(String code) throws
                PrefixMismatchException,
                PostfixMismatchException {
            if ( ! code.startsWith(prefix())) {
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

    public static LocationCode.Builder builder() {
        return new LocationCode.Builder(SEPARATOR);
    }

    public LocationCode(String prefix, String postfix, List<String> segments) {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
