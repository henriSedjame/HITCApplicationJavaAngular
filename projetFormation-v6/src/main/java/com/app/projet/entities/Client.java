package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur  {
	

    // ATTRIBUTS

    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "id_panier" )
    @JsonManagedReference(value = "client-panier")
    private Panier panier;

    @OneToOne(cascade = {CascadeType.PERSIST ,CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="id_favoris")
    @JsonManagedReference(value = "client-favoris")
    private Favoris favoris;

    // CONSTRUCTEUR


    public Client() {
    	this.favoris = new Favoris();
    	this.panier = new Panier();

        this.panier.setClient( this );
        this.favoris.setClient( this );

    }

    public Client(String nom, String prenom, String email, Date dateNaissance, Adresse adresse) {
        super(nom, prenom, email, dateNaissance,adresse);
        this.favoris = new Favoris();
        this.panier = new Panier();

        this.panier.setClient( this );
        this.favoris.setClient( this );
    }

    public Client(String nom, String prenom, String email, Date dateNaissance, Adresse adresse, IdentifiantsConnexion id) {
  		super(nom, prenom, email, dateNaissance, adresse, id);
        this.favoris = new Favoris();
        this.panier = new Panier();

        this.panier.setClient( this );
        this.favoris.setClient( this );
  		
  	}

    
    
    // GETTERS SETTERS

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }


	public Favoris getFavoris() {
		return favoris;
	}

	public void setFavoris(Favoris favoris) {
		this.favoris = favoris;
	}
    
}
