package org.fscl.core.adapters.driven.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.fscl.core.domain.entity.id.FsclEntityId;

@AllArgsConstructor
@Getter
public class EntityDto {
    private FsclEntityId id;
    private String name;
    private String description;
}
