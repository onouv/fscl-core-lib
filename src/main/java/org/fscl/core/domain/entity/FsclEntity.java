package org.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.measure.Quantity;

import org.fscl.core.commons.entity.FsclEntityData;
import org.fscl.core.commons.entity.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Base class for all FSCL entities.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Getter
public abstract class FsclEntity<T extends FsclEntity<T>> extends FsclEntityData {

	protected List<T> children;

	protected T parent;

	protected List<Parameter> parameters;

	protected FsclEntity(FsclEntityId id, T parent, String name, String description) {
		super(id, name, description);
		this.parent = parent;
		this.children = new ArrayList<>();
		this.parameters = new ArrayList<>();
	}

	public Parameter getParameter(String name) {
		ListIterator<Parameter> iter = this.parameters.listIterator();
		Parameter p = null;
		while (iter.hasNext()) {
			p = iter.next();
			if (p.name.equals(name)) {
				return p;
			}
		}

		return null;
	}

	public void addParameter(String name, Parameter.QuantityType type, Quantity<?> quantity) {
		this.parameters.add(new Parameter(name, type, quantity));
	}

	public void addParameter(Parameter parameter) {
		this.parameters.add(parameter);
	}
}
