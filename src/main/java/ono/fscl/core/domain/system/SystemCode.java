package ono.fscl.core.domain.system;

import ono.fscl.core.domain.entity.id.EntityCode;
import ono.fscl.core.domain.entity.id.SegmentFormatException;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public final class SystemCode extends EntityCode {
    public static final String PREFIX = "#";
    public static final String SEPARATOR = ".";

    public SystemCode(String prefix, String postfix, List<String> segments) throws SegmentFormatException, PatternSyntaxException {
        super(prefix, postfix, segments, SEPARATOR);
    }
}
