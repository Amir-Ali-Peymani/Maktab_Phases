package com.example.phase3.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BaseHttpException {

    public AuthenticationException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
