package org.fscl.core.commons;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceIdDataMapper {
	public static final ResourceIdDataMapper INSTANCE = Mappers.getMapper(ResourceIdDataMapper.class);

	ResourceIdDataDto outwards(ResourceId id);

	ResourceId inwards(ResourceIdDataDto dto);
}
