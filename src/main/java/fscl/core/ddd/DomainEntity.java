package fscl.core.ddd;

import lombok.AllArgsConstructor;

/** An DomainEntity is considered to
 *  - have a unique identity as represented by an identifier of type T
 *  - have an individuality that can can be distinguished from all other Entities of same or different type
 * @param <T> type of identifier
 */
@AllArgsConstructor
public abstract class DomainEntity<T> extends IdentifiableDomainObject {
}
