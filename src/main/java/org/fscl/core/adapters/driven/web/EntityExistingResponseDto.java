package org.fscl.core.adapters.driven.web;

import org.fscl.core.commons.entity.ResourceId;
import org.fscl.core.ports.lifecycle.FsclEntityState;

public record EntityExistingResponseDto(ResourceId id, FsclEntityState state) {
}
