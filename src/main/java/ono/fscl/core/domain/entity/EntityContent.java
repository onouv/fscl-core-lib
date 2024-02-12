package ono.fscl.core.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public abstract class EntityContent {
    @NonNull
    protected String name;
    
    protected String description;
}
