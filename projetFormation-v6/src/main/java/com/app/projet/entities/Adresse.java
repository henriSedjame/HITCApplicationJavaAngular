package com.app.projet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable 
public class Adresse implements Serializable {

	// ATTRIBUTS

	private String rue;
	@Column(length = 50)
	private String ville;
	@Column( name = "Code_Postal", length = 5 )
	private int codePostal;

	// CONSTRUCTEURS
	public Adresse(String rue, String ville, int codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Adresse() {

	}

	// GETTERS SETTERS

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostale) {
		this.codePostal = codePostale;
	}

}
