package org.fscl.core.domain.resource;

import org.fscl.core.commons.ResourceId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public abstract class FunctionResource extends Resource<FunctionResource> {

	protected FunctionResource(ResourceId id, FunctionResource parent, String name, String description) {
		super(id, parent, name, description);

		// TODO: deal with id format validation here ?
	}

}
