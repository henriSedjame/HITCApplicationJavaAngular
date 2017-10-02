package com.app.projet.exceptions;

public class EmptyResponseException extends Exception {

    private String message = "";

    public EmptyResponseException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
