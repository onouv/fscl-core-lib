package org.fscl.core.adapters.driving.persistence;

import org.fscl.core.commons.ResourceIdDataDto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
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
public abstract class ResourceDataDto {
	@EmbeddedId
	protected ResourceIdDataDto entityId;

	protected String name;
	protected String description;

	// TODO: support parent/child relations

	// TODO: support parameters
}