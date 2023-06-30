package fscl.core.ddd;

/**
 * An annotation to indicate that a class is representing a value.
 *
 * A Value Object in domain driven design models an immutable conceptual whole which does not have a unique identity.
 * It conceptually is not a thing but describes, quantifies or measures a thing.
 *
 * Implementations of this interface must implement equals() and hashCode().
 */
public interface ValueObject extends DomainObject {
}
