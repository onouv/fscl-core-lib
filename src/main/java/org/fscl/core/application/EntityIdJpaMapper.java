package org.fscl.core.application;

import org.fscl.core.adapters.driving.persistence.entity.EntityIdJpaDto;
import org.fscl.core.commons.entity.ResourceId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityIdJpaMapper {
	public static final EntityIdJpaMapper INSTANCE = Mappers.getMapper(EntityIdJpaMapper.class);

	EntityIdJpaDto outwards(ResourceId id);

	ResourceId inwards(EntityIdJpaDto dto);
}
