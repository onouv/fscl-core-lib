package org.fscl.core.application;

import org.fscl.core.commons.entity.FsclEntityId;
import org.fscl.core.ports.lifecycle.FsclEntityState;

public record EntityRecord(FsclEntityId id, FsclEntityState state) {
}
