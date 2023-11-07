package com.example.phase3.exception;

public class InvalidIdException extends BadRequestException{
    public InvalidIdException() {
        super("Id is not a valid");
    }
}
