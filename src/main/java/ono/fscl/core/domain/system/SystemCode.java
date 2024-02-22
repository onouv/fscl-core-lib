package ono.fscl.core.domain.system;

import ono.fscl.core.domain.entity.id.EntityCode;

public final class SystemCode extends EntityCode {
    public static final String PREFIX = "#";
    public static final String SEPARATOR = ".";
    
    public SystemCode() {
        super(PREFIX, SEPARATOR, REGEXP);
    }
}
