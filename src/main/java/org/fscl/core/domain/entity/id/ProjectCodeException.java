package org.fscl.core.domain.entity.id;

public class ProjectCodeException extends Exception {
    protected ProjectCodeException(String msg) { super(msg); }
    protected ProjectCodeException(String msg, Throwable root) {
        super(msg, root);
    }
}
