package com.app.projet.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("admin")     // Heritage de l'utilisateur
public class Administrateur extends Utilisateur  {


    // CONSTRUCTEURS

    public Administrateur(String nom, String prenom, String email, Date dateNaissance, Adresse adresse) {
        super(nom, prenom, email, dateNaissance, adresse);
    }

    public Administrateur(String nom, String prenom, String email, Date dateNaissance, Adresse adresse, IdentifiantsConnexion identifiantsConnexion) {
        super(nom, prenom, email, dateNaissance, adresse, identifiantsConnexion);
    }

    public Administrateur(String nom, String prenom, String email, Date dateNaissance) {
        super(nom, prenom, email, dateNaissance);
    }

    public Administrateur() {
        super();
    }
}
