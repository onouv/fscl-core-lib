package org.fscl.core.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public abstract class FsclEntityContent {
    @NonNull
    protected String name;
    
    protected String description;
}
