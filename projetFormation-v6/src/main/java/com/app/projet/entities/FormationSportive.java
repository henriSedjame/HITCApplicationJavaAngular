package com.app.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("sport")
public class FormationSportive extends Produit  {

    // ATTRIBUTS

    @Enumerated(EnumType.STRING)
    private Sport sportEnseigne;

    // CONSTRUCTEURS

    public FormationSportive() {
    	super();

    }

    public FormationSportive(String designation, int stock, boolean disponibilite, double prixUnitaire, Sport sportEnseigne) {
        super( designation, stock, disponibilite, prixUnitaire);
        this.sportEnseigne = sportEnseigne;
    }

    public FormationSportive(String designation, int stock, boolean disponibilite, double prixUnitaire) {
        super(designation, stock, disponibilite, prixUnitaire);
    }

    public FormationSportive(String designation, int stock, boolean disponibilite, double prixUnitaire, String urlImage) {
        super(designation, stock, disponibilite, prixUnitaire, urlImage);
    }
    
    public FormationSportive(String designation, int stock, boolean disponibilite, double prixUnitaire, DetailsFormation det,String urlImage, Sport sportEnseigne) {
        super(designation, stock, disponibilite, prixUnitaire, det, urlImage);
        this.sportEnseigne = sportEnseigne;
    }

    // GETTERS SETTERS

    public Sport getSportEnseigne() {
        return sportEnseigne;
    }

    public void setSportEnseigne(Sport sportEnseigne) {
        this.sportEnseigne = sportEnseigne;
    }
}
