package com.example.phase3.exception;

public class InvalidEmailException extends BadRequestException{
    public InvalidEmailException() {
        super("email is invalid");
    }
}
