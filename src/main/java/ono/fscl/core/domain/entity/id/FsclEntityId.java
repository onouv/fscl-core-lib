package ono.fscl.core.domain.entity.id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class FsclEntityId<C extends FsclEntityCode> {
    public final C code;
    public final String project;
}
