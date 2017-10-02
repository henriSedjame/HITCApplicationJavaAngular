package com.app.projet.entities;

public enum Sport {
    FOOT("FootBall"), 
    BASKET("BasketBall"), 
    GYM("Gymnastique"),
	VOLLEYBALL("Volley-ball"),
	YOGA("Yoga"),
	QUIDDITCH("Quidditch");

    private String label;

    Sport(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
