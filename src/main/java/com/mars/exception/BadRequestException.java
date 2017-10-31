package com.mars.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestHttpException {

    private static final long serialVersionUID = 4237276476234L;

    public BadRequestException() {
        super("Bad Request", HttpStatus.BAD_REQUEST);
    }
}
