package com.example.phase3.exception;

public class PriceException extends RuntimeException{
    public PriceException() {
        super("Price Is not valid number !!");
    }
}
