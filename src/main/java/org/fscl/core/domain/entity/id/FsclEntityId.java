package org.fscl.core.domain.entity.id;


import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection  // to serve as an identifier in db queries
public record FsclEntityId(String code, String project){}
