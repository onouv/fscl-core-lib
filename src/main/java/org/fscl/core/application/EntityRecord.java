package org.fscl.core.application;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.ports.web.driven.lifecycle.FsclEntityState;

public record EntityRecord(FsclEntityId id, FsclEntityState state) {
}
