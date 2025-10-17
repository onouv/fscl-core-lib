package org.fscl.core.ports.web.driven.error;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Data
public class ErrorDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String errorCode;

    public ErrorDto() {
        timestamp = LocalDateTime.now();
    }
}
