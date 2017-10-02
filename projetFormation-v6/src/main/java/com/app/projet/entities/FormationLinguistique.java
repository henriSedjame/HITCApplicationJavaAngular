package com.app.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("lang")
public class FormationLinguistique extends Produit  {
	
	// ATTRIBUTS

	@Enumerated(EnumType.STRING)
	private Langues languesEnseigne;

	//CONSTRUCTEURS

	public FormationLinguistique() {
		super();
	}

	public FormationLinguistique(String designation, int stock, boolean disponibilite, double prixUnitaire,
								 Langues langues) {
		super(designation, stock, disponibilite, prixUnitaire);
		this.languesEnseigne = langues;
	}

	public FormationLinguistique(String designation, int stock, boolean disponibilite, double prixUnitaire) {
		super(designation, stock, disponibilite, prixUnitaire);
	}

	public FormationLinguistique(String designation, int stock, boolean disponibilite, double prixUnitaire, String urlImage) {
		super(designation, stock, disponibilite, prixUnitaire, urlImage);
	}
	
	public FormationLinguistique(String designation, int stock, boolean disponibilite, double prixUnitaire, DetailsFormation det,String urlImage, Langues langues) {
		super(designation, stock, disponibilite, prixUnitaire, det,urlImage);
		this.languesEnseigne = langues;
	}

	// GETTERS SETTERS

	public Langues getLanguesEnseigne() {
		return languesEnseigne;
	}

	public void setLanguesEnseigne(Langues languesEnseigne) {
		this.languesEnseigne = languesEnseigne;
	}
	
	
	
}
