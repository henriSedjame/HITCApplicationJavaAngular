package com.app.projet.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("info")
public class FormationInformatique extends Produit  {
	
	//ATTRIBUTS

	@Enumerated(EnumType.STRING)
	private Techno technoEnseigne;

	// CONSTRUCTEURS

	public FormationInformatique() {
		super();
	}

	public FormationInformatique(String designation, int stock, boolean disponibilite, double prixUnitaire,
								 Techno techno) {
		super(designation, stock, disponibilite, prixUnitaire);
		this.technoEnseigne = techno;
	}

	public FormationInformatique(String designation, int stock, boolean disponibilite, double prixUnitaire) {
		super(designation, stock, disponibilite, prixUnitaire);
	}

	public FormationInformatique(String designation, int stock, boolean disponibilite, double prixUnitaire, String urlImage) {
		super(designation, stock, disponibilite, prixUnitaire, urlImage);
	}
	
	public FormationInformatique(String designation, int stock, boolean disponibilite, double prixUnitaire, DetailsFormation det, String urlImage, Techno techno) {
		super(designation, stock, disponibilite, prixUnitaire, det, urlImage);
		this.technoEnseigne = techno;
	}


	
	// GETTERS SETTERS
	public Techno getTechnoEnseigne() {
		return technoEnseigne;
	}

	public void setTechnoEnseigne(Techno techno) {
		this.technoEnseigne = techno;
	}
	
	
}
