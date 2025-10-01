package org.fscl.core.application.function;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.ports.driven.web.lifecycle.FsclEntityState;

public record EntityRecord(FsclEntityId id, FsclEntityState state) {
}
