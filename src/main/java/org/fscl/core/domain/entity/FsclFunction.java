package org.fscl.core.domain.entity;

import org.fscl.core.commons.entity.ResourceId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public abstract class FsclFunction extends FsclEntity<FsclFunction> {

	protected FsclFunction(ResourceId id, FsclFunction parent, String name, String description) {
		super(id, parent, name, description);

		// TODO: deal with id format validation here ?
	}

}
