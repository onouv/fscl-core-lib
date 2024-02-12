package ono.fscl.core.domain.location;

import ono.fscl.core.domain.entity.id.EntityCode;

public final class LocationCode extends EntityCode {
    public static final String PREFIX = "+";
    public static final String SEPARATOR = ".";
    
    
    public LocationCode() {
        super(PREFIX, SEPARATOR, REGEXP);
    }
}
