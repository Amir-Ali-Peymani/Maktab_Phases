package com.example.phase3.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseHttpException extends Exception{

    public BaseHttpException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

}
