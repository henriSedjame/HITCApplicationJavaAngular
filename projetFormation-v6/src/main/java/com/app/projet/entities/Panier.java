package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("panier")
public class Panier extends FicheCommande implements Serializable {

	// ATTRIBUTS

    @OneToOne(mappedBy = "panier")
	@JsonBackReference(value="client-panier")
	private Client client;

	// CONSTRUCTEURS

	public Panier() {
	}

	public Panier(Client client) {
		this.client = client;
	}


	// GETTERS SETTERS


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
