package ono.fscl.core.appservices;


import ono.fscl.core.domain.entity.id.PostfixMismatchException;
import ono.fscl.core.domain.entity.id.PrefixMismatchException;
import ono.fscl.core.domain.entity.id.SeparatorMismatchException;
import ono.fscl.core.domain.function.FunctionCode;
import ono.fscl.core.ports.upstream.web.id.FsclEntityCodeDto;
import ono.fscl.core.ports.upstream.web.id.FsclEntityIdDto;

public class FunctionCodeMapper {
    public FunctionCode from(FsclEntityCodeDto dto) throws
            PrefixMismatchException, PostfixMismatchException, SeparatorMismatchException {
        return FunctionCode.builder()
                .withPrefix(dto.getPrefix())
                .withPostfix(dto.getPostfix())
                .withSeparator(dto.getSegmentSeparator())
                .withCode(dto.getCode())
                .build();
    }

    public FsclEntityCodeDto to(FunctionCode code) {
        return new FsclEntityCodeDto(
                code.prefix,
                code.postfix,
                code.segmentSeparator,
                code.toString());
    }

}
