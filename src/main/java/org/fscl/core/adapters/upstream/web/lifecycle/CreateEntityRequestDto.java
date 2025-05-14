package org.fscl.core.adapters.upstream.web.lifecycle;

import lombok.*;
import org.fscl.core.domain.entity.id.FsclEntityId;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateEntityRequestDto {
    private FsclEntityId id;
    private String name;
    private String description;
}
