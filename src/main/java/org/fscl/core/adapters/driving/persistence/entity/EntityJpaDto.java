package org.fscl.core.adapters.driving.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class EntityJpaDto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_id_gen")
	@SequenceGenerator(name = "entity_id_gen", sequenceName = "entity_seq")
	@Column(name = "id", updatable = false)
	protected Long id;

	@Embedded
	protected EntityIdJpaDto entityId;

	protected String name;
	protected String description;

	// TODO: support parent/child relations

	// TODO: support parameters
}