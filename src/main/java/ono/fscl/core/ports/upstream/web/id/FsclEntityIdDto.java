package ono.fscl.core.ports.upstream.web.id;

import lombok.Data;

@Data
public class FsclEntityIdDto {
    private final FsclEntityCodeDto code;
    private final String project;
}
