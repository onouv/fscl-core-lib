package org.fscl.core.domain.entity;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class FsclEntityContent {
    @NonNull
    protected String name;
    
    protected String description;
}
