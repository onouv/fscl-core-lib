package org.fscl.core.adapters.driving.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// Serves as @Entity, since @MappedSuperclass alone 
// will collide with debezium and the hibernate default 
// persistence unit
// TODO: Remove once there are other concrete @Entity persisted classes in the library
@Entity
public class DummyJpaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;
}
