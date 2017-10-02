package com.app.projet.exceptions;

public class ClientAlreadyExisting extends Exception {

    private String message = "";

    public ClientAlreadyExisting( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
