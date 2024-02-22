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

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class Entity<
    C extends EntityCode,
    T extends Entity<C, T>>
    
    extends EntityContent {    
    
    @NonNull
    protected EntityId<C> identifier;
    protected List<T> children;
    protected T parent;
    protected List<Parameter> parameters;

    
    public Entity(EntityId<C> id, T parent, String name, String description) {
        super(name, description);
        
        this.identifier = id;
        this.parent = parent;
        this.children = new ArrayList<T>();
    }

    public abstract EntityId<C> getIdentifier();

    public Parameter getParameter(String name) {
        ListIterator<Parameter> iter = this.parameters.listIterator();
        Parameter p = null;
        while(iter.hasNext()) {
            p = iter.next();
            if (p.name.equals(name)) {
                return p;
            }
        }

        return p;
    }
    
}

