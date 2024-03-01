package ono.fscl.core.domain.location;

import ono.fscl.core.domain.component.ComponentCode;
import ono.fscl.core.domain.entity.id.EntityCode;
import ono.fscl.core.domain.entity.id.SegmentFormatException;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class LocationCode extends EntityCode {
    public static final String PREFIX = "+";
    public static final String SEPARATOR = ".";
    public static class Builder extends EntityCode.Builder<LocationCode>{
        @Override
        public LocationCode build() throws SegmentFormatException {
            String prefix = this.isShadow ? "(" + PREFIX : PREFIX;
            String postfix = this.isShadow ? ")" : null;

            try {
                return new LocationCode(prefix, postfix, this.segms);
            } catch (PatternSyntaxException e) {
                throw new RuntimeException("Software error: ill-formed regexp-matching pattern");
            }
        }
    }

    public static LocationCode.Builder builder() {
        return new LocationCode.Builder();
    }

    public LocationCode(String prefix, String postfix, List<String> segments) throws SegmentFormatException, PatternSyntaxException {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
