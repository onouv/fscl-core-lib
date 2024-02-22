package ono.fscl.core.domain.component;

import ono.fscl.core.domain.entity.id.EntityCode;

public final class ComponentCode extends EntityCode {
    public static final String PREFIX = "-";
    public static final String SEPARATOR = ".";
    
    public ComponentCode() {
        super(PREFIX, SEPARATOR, REGEXP);
    }
}
