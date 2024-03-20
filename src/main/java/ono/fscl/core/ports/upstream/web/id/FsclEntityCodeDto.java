package ono.fscl.core.ports.upstream.web.id;

import lombok.Data;

@Data
public final class FsclEntityCodeDto {
    private final String prefix;
    private final String postfix;
    private final String segmentSeparator;
    private final String code;
}
