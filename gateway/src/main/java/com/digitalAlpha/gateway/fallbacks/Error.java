package com.digitalAlpha.gateway.fallbacks;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class Error {
    private int code;
    private HttpStatus status;
    private String message;
}
