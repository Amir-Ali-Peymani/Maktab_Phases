package com.example.phase3.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseHttpException{

    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
    public BadRequestException(String message) {
        super(message);
    }

}

