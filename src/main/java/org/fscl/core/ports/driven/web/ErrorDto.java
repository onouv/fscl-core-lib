package org.fscl.core.ports.driven.web;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ErrorDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String errorCode;

    public ErrorDto() {
        timestamp = LocalDateTime.now();
    }
}
