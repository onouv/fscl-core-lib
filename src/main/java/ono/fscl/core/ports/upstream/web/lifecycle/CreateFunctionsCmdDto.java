package ono.fscl.core.ports.upstream.web.lifecycle;

import lombok.Data;
import ono.fscl.core.ports.upstream.web.id.FsclEntityIdDto;

import java.util.List;


@Data
public class CreateFunctionsCmdDto {
    private List<FsclEntityIdDto> functions;
}
