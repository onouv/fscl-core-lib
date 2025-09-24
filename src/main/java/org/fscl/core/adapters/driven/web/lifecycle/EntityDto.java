package org.fscl.core.adapters.driven.web.lifecycle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;

@AllArgsConstructor
@Getter
public class EntityDto<T extends FsclEntity<T>> {
    private FsclEntityId id;
    private String name;
    private String description;

    public static <T extends FsclEntity<T>> EntityDto<T> of(FsclEntity<T> entity) {
        return new EntityDto<>(
            entity.getEntityId(), 
            entity.getName(), 
            entity.getDescription());
    }
}
