package org.fscl.core.adapters.upstream.web.lifecycle;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.ports.upstream.web.lifecycle.FsclEntityState;

public record EntityExistingResponseDto(FsclEntityId id, FsclEntityState state) {
}
