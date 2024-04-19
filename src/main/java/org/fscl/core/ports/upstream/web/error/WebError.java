package org.fscl.core.ports.upstream.web.error;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
public class WebError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String errorCode;

    public WebError() {
        timestamp = LocalDateTime.now();
    }
}
