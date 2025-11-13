package org.fscl.core.adapters.driven.web;

import org.fscl.core.commons.ResourceId;
import org.fscl.core.ports.lifecycle.ResourceDistributionState;

public record ResourceExistingResponseDto(ResourceId id, ResourceDistributionState state) {
}
