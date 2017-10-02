package com.app.projet.exceptions;

public class StockNegatifException extends Exception {

    private String message = "";

    public StockNegatifException( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
