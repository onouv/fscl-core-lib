package ono.fscl.core.domain.function;

import java.util.regex.PatternSyntaxException;

import ono.fscl.core.domain.entity.id.EntityCode;

public final class FunctionCode extends EntityCode {

    public static final String PREFIX = "=";
    public static final String SEPARATOR = ".";
    
    public FunctionCode() throws PatternSyntaxException {
        super(PREFIX, SEPARATOR);
    }
    
}
