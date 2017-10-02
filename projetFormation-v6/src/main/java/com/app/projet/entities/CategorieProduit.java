package com.app.projet.entities;

public enum CategorieProduit {
    INFORMATIQUE("Informatique"), ARTISTIQUE("Artistique"), LINGUISTIQUE("Linguistique"), SPORTIVE("Sportive");

    String label;

    CategorieProduit(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
