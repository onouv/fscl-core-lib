package org.fscl.core.application;

import org.fscl.core.commons.entity.ResourceId;
import org.fscl.core.ports.lifecycle.FsclEntityState;

public record EntityRecord(ResourceId id, FsclEntityState state) {
}
