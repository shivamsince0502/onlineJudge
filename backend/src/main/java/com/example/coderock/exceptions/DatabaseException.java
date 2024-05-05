package com.example.coderock.exceptions;

public class DatabaseException extends RuntimeException{
    public final String errorMessage;

    public DatabaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }



}
