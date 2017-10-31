package com.mars.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends RestHttpException {

    private static final long serialVersionUID = 427547656458387687L;

    public InternalServerException() {
        this("Erro interno no servidor");
    }

    public InternalServerException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
