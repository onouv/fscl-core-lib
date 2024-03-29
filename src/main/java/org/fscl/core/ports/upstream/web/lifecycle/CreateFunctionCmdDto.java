package org.fscl.core.ports.upstream.web.lifecycle;

import lombok.Data;
import org.fscl.core.ports.upstream.web.id.FsclEntityIdDto;


@Data
public class CreateFunctionCmdDto {
    private FsclEntityIdDto function;
}
