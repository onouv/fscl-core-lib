package org.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.measure.Quantity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;

/**
 * Base class for all FSCL entities.
 */
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Getter
public abstract class FsclEntity<T extends FsclEntity<T>> {

    @NonNull
    protected String project;

    @NonNull
    protected String code;

    protected String name;

    protected String description;

    protected List<T> children;

    protected T parent;

    protected List<Parameter> parameters;

    public FsclEntity(FsclEntityId id, T parent, String name, String description) {
        this.project = id.project();
        this.code = id.code();
        this.name = name;
        this.description = description;
        this.parent = parent;
        this.children = new ArrayList<T>();
        this.parameters = new ArrayList<Parameter>();
    }

    public FsclEntityId getEntityId() {
        return new FsclEntityId(this.project, this.code);
    }

    public void setEntityId(FsclEntityId id) {
        this.code = id.code();
        this.project = id.project();
    }

    public Parameter getParameter(String name) {
        ListIterator<Parameter> iter = this.parameters.listIterator();
        Parameter p = null;
        while(iter.hasNext()) {
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

