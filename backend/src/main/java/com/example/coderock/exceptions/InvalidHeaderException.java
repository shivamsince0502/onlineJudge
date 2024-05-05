package com.example.coderock.exceptions;

public class InvalidHeaderException extends RuntimeException{
    public final String errorMessage;

    public InvalidHeaderException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
