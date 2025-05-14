package org.fscl.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.measure.Quantity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import org.fscl.core.domain.entity.id.FsclEntityId;
import org.fscl.core.domain.parameter.Parameter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FsclEntity<T extends FsclEntity<T>> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected String project;

    @NonNull
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    String code;

    protected String name;

    protected String description;

    @Transient // TODO: support parent/child relations
    protected List<T> children;

    @Transient // TODO: support parent/child relations
    protected T parent;

    @Transient
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

