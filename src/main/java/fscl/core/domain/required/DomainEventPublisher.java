package fscl.core.domain.required;

import fscl.core.ddd.DomainEvent;
import java.util.List;

public interface DomainEventPublisher {
  boolean publish(List<DomainEvent> events);
}
