package org.fscl.core.domain.function;

import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FsclFunction extends FsclEntity<FsclFunction> {

	public FsclFunction(FsclEntityId id, FsclFunction parent, String name, String description) {
		super(id, parent, name, description);
		// TODO Auto-generated constructor stub
	}

}
