package org.fscl.core.adapters.driving.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass 
public abstract class EntityJpaData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="entity_id_gen")
    @SequenceGenerator(name = "entity_id_gen", sequenceName = "entity_seq")
    @Column(name = "id", updatable = false)
    protected Long id;

    protected String project;
    protected String code;
    protected String name;
    protected String description;

    // TODO: support parent/child relations

    // TODO: support parameters
}