package com.app.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("art")
public class FormationArtistique extends Produit  {



	// ATTRIBUTS

	@Enumerated(EnumType.STRING)
	private Art artEnseigne;

	// CONSTRUCTEURS


	public FormationArtistique() {
		super();

	}

	public FormationArtistique(String designation, int stock, boolean disponibilite, double prixUnitaire,
							   Art art) {
		super(designation, stock, disponibilite, prixUnitaire);
		this.artEnseigne = art;
	}

	public FormationArtistique(String designation, int stock, boolean disponibilite, double prixUnitaire) {
		super(designation, stock, disponibilite, prixUnitaire);
	}

	public FormationArtistique(String designation, int stock, boolean disponibilite, double prixUnitaire, String urlImage) {
		super(designation, stock, disponibilite, prixUnitaire, urlImage);
	}
	
	public FormationArtistique(String designation, int stock, boolean disponibilite, double prixUnitaire, DetailsFormation det,String urlImage, Art art) {
		super(designation, stock, disponibilite, prixUnitaire, det, urlImage);
		this.artEnseigne = art;
	}
	

	// GETTERS SETTERS

	public Art getArtEnseigne() {
		return artEnseigne;
	}

	public void setArtEnseigne(Art art) {
		this.artEnseigne = art;
	}
	
	

}
