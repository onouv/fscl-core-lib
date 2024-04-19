package org.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;
import org.fscl.core.ports.upstream.web.lifecycle.FsclEntityState;

import javax.measure.Quantity;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public abstract class FsclEntity<T extends FsclEntity<T>>  extends FsclEntityContent {
    
    @NonNull
    protected FsclEntityId identifier;
    protected List<T> children;
    protected T parent;
    protected List<Parameter> parameters;
    protected FsclEntityState state;

    public FsclEntity(FsclEntityId id, T parent, String name, String description) {
        super(name, description);
        
        this.identifier = id;
        this.parent = parent;
        this.children = new ArrayList<T>();
        this.parameters = new ArrayList<Parameter>();
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

