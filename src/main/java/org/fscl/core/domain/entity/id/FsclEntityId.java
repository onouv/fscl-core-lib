package org.fscl.core.domain.entity.id;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Embeddable;

@RegisterForReflection  // to serve as an identifier in db queries
@Embeddable
public record FsclEntityId(String project, String code){

    @Override
    public java.lang.String toString() {
        return String.format("{ project=%s, code=%s }", project, code);
    }
}
