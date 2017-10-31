package com.mars.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ErrorResponse {

    private final int httpStatusCode;
    private final String message;

    public ErrorResponse(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

}
