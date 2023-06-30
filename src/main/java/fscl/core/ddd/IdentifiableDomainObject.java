package fscl.core.ddd;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
public abstract class IdentifiableDomainObject<T> implements DomainObject {
  public final T id = null;
}
