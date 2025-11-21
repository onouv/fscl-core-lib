package org.fscl.core.commons;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceIdDataMapper {

	public ResourceIdDataDto outwards(ResourceId id) {
		if (id == null) {
			throw new IllegalArgumentException("ResourceId provided must not be null");
		}

		return new ResourceIdDataDto(id.getProject(), id.getCode());
	}

	public ResourceId inwards(ResourceIdDataDto dto) {
		if (dto == null) {
			throw new IllegalArgumentException("ResourceIdDataDto provided must not be null");
		}

		return new ResourceId(dto.getProject(), dto.getCode());
	}
}
