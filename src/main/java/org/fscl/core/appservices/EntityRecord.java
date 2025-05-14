package org.fscl.core.appservices;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.ports.upstream.web.lifecycle.FsclEntityState;

public record EntityRecord(FsclEntityId id, FsclEntityState state) {
}
