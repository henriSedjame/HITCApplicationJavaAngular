package com.app.projet.exceptions;

public class ClientNotFoundException extends Exception {

    private String message = "";

    public ClientNotFoundException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
