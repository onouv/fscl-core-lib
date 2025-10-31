package org.fscl.core.adapters.driven.web;

import org.fscl.core.commons.entity.FsclEntityId;
import org.fscl.core.ports.lifecycle.FsclEntityState;

public record EntityExistingResponseDto(FsclEntityId id, FsclEntityState state) {
}
