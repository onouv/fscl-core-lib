package org.fscl.core.appservices;


import org.fscl.core.domain.entity.id.PostfixMismatchException;
import org.fscl.core.domain.entity.id.PrefixMismatchException;
import org.fscl.core.domain.entity.id.SeparatorMismatchException;
import org.fscl.core.domain.function.FunctionCode;
import org.fscl.core.ports.upstream.web.id.FsclEntityCodeDto;

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
