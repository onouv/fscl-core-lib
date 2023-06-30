package fscl.core.ddd;

import lombok.AllArgsConstructor;

/**
 * An aggregate root in domain driven design is an entity in an aggregate that
 *  * - owns all other elements inside the aggegate and
 *  * - is named like the aggregate
 * @param <T>
 */
@AllArgsConstructor
public class AggregateRoot<T> extends IdentifiableDomainObject<T> {
}
