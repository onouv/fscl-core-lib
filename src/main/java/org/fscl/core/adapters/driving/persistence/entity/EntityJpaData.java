package org.fscl.core.adapters.driving.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="entity")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass 
// not possible to use this instead of @Entity, @Table and @Inheritance 						
// since it will collide with debezium and the hibernate default persistence unit
public abstract class EntityJpaData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    protected String project;
    protected String code;
    protected String name;
    protected String description;

    // TODO: support parent/child relations

    // TODO: support parameters
}