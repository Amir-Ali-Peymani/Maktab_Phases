package com.example.phase3.exception;

public class UnAuthorizedSpecialistException extends Exception{
    public UnAuthorizedSpecialistException() {
        super("Specialist has not been Confirmed");
    }
}
