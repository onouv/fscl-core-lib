package org.fscl.core.domain.entity.id;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Embeddable;

@RegisterForReflection  // to serve as an identifier in db queries
@Embeddable
public record FsclEntityId(String code, String project){}
