package org.fscl.core.adapters.downstream.persistence;

import org.fscl.core.domain.entity.EntityException;
import org.fscl.core.domain.entity.id.FsclEntityId;

public class DuplicateEntityException extends EntityException {

    FsclEntityId id;

    public DuplicateEntityException(FsclEntityId id) {
        super(String.format("Duplicate entity with id %s found.", id));
        this.id = id;
    }
}
