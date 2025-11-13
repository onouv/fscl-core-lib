package org.fscl.core.application;

import org.fscl.core.commons.ResourceId;
import org.fscl.core.ports.lifecycle.ResourceDistributionState;

public record ResourceRecord(ResourceId id, ResourceDistributionState state) {
}
