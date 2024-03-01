package ono.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import ono.fscl.core.domain.entity.id.FsclEntityCode;
import ono.fscl.core.domain.entity.id.FsclEntityId;
import ono.fscl.core.domain.parameter.Parameter;

import javax.measure.Quantity;


@Getter
@EqualsAndHashCode(callSuper = true)

public abstract class FsclEntity<
    C extends FsclEntityCode,
    T extends FsclEntity<C, T>>
    
    extends EntityContent {    
    
    @NonNull
    @Getter(AccessLevel.NONE)
    protected FsclEntityId<C> identifier;
    protected List<T> children;
    protected T parent;
    protected List<Parameter> parameters;

    
    public FsclEntity(FsclEntityId<C> id, T parent, String name, String description) {
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

