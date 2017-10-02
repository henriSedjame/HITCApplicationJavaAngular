package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@DiscriminatorValue("commande")  // Herite de ficheCommande
public class Commande extends FicheCommande  {


	// ATTRIBUTS

    private String date;


    private Long idClient;
    
    // CONSTRUCTEURS


	public Commande() {
	}

	
	public Commande(String date, Long idClient) {
		this.date = date;
		this.idClient = idClient;
	}

	// GETTERS SETTERS

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	
	
	

  
	
	


    
    
}
