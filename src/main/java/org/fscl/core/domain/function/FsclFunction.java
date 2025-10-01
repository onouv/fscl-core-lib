package org.fscl.core.domain.function;

import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class FsclFunction extends FsclEntity<FsclFunction> {

	public FsclFunction(FsclEntityId id, FsclFunction parent, String name, String description) {
		super(id, parent, name, description);
		
		// TODO: deal with id format validation
	}

}
