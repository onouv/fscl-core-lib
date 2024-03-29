package org.fscl.core.ports.upstream.web.error;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
public class WebError {
    private HttpResponseStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String userMessage;
    private List<SubError> subErrors;

    public WebError() {
        timestamp = LocalDateTime.now();
    }
}
