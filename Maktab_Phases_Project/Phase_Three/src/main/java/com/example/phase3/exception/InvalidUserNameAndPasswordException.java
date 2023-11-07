package com.example.phase3.exception;

public class InvalidUserNameAndPasswordException extends BadRequestException {
    public InvalidUserNameAndPasswordException() {
        super("Username or password is not valid");
    }
}
