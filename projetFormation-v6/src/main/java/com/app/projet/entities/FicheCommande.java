package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FicheCommande {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long id;
    
    // ATTRIBUTS
    
    private double prixTotal;

    @OneToMany( mappedBy = "ficheCommande", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@JsonManagedReference(value = "fiche-ligne")
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
    
    // CONSTRUCTEURS

	public FicheCommande() { }

	// GETTERS SETTERS
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrixTotal() {

		if (this.getLigneDeCommandes().size() == 0 ) {
			return 0;
		}

		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		
		this.prixTotal = prixTotal;
	}

	public List<LigneDeCommande> getLigneDeCommandes() {
		return ligneDeCommandes;
	}

	public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}
	
    
   
    
    
}

