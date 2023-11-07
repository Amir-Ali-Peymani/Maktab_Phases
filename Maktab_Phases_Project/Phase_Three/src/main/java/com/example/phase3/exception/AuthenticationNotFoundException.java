package com.example.phase3.exception;

public class AuthenticationNotFoundException extends AuthenticationException{
    public AuthenticationNotFoundException() {
        super("User not found");
    }
}
