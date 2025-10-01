package org.fscl.core.adapters.driven.web;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.ports.driven.web.lifecycle.FsclEntityState;

public record EntityExistingResponseDto(FsclEntityId id, FsclEntityState state) {
}
