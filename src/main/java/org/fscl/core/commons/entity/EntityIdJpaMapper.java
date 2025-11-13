package org.fscl.core.commons.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityIdJpaMapper {
	public static final EntityIdJpaMapper INSTANCE = Mappers.getMapper(EntityIdJpaMapper.class);

	EntityIdJpaDto outwards(ResourceId id);

	ResourceId inwards(EntityIdJpaDto dto);
}
