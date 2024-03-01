package ono.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import ono.fscl.core.domain.entity.id.EntityCode;
import ono.fscl.core.domain.entity.id.EntityId;
import ono.fscl.core.domain.parameter.Parameter;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.measure.Quantity;


@Getter
@EqualsAndHashCode(callSuper = true)
@Aggregate
public abstract class Entity<
    C extends EntityCode,
    T extends Entity<C, T>>
    
    extends EntityContent {    
    
    @NonNull
    @AggregateIdentifier
    protected EntityId<C> identifier;
    protected List<T> children;
    protected T parent;
    protected List<Parameter> parameters;

    
    public Entity(EntityId<C> id, T parent, String name, String description) {
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

