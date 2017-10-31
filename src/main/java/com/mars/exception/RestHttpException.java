package com.mars.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mars.json.ErrorResponse;
import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;

public abstract class RestHttpException extends ServletException {

    private static final long serialVersionUID = 1235572736437684567L;

    private final HttpStatus status;

    public RestHttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status.value();
    }

    @Override
    public String toString() {
        return status + " " + super.getMessage();
    }

    public String toJson() throws JsonProcessingException {
        return new ErrorResponse(status.value(), getMessage()).toJson();
    }

    public String to(String uri) throws JsonProcessingException {
        if (uri.startsWith("/rest")) {
            return toJson();
        }

        return toString();
    }
}
