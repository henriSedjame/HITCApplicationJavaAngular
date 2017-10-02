package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class DetailsFormation  {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    // ATTRIBUTS
    
    private int duree;


    @Column (length = 1000)
    private String descriptif;

    @ManyToOne
    @JoinColumn(name = "id_organisme_formation")
	@JsonBackReference(value = "org-det")
    private OrganismeFormation organismeFormation;

    @OneToOne(mappedBy = "detailsFormation")
	@JsonBackReference(value = "prod-det")
    private Produit produit;
    
    // CONSTRUCTEURS

	public DetailsFormation(int duree, String descriptif, OrganismeFormation organismeFormation,
			Produit produit) {
		super();
		this.duree = duree;
		this.descriptif = descriptif;
		this.organismeFormation = organismeFormation;
		this.produit = produit;
	}
	
	public DetailsFormation(int duree, String descriptif, OrganismeFormation organismeFormation) {
		super();
		this.duree = duree;
		this.descriptif = descriptif;
		this.organismeFormation = organismeFormation;
		
	}

	public DetailsFormation(int duree, String descriptif) {
		super();
		this.duree = duree;
		this.descriptif = descriptif;
	}

	public DetailsFormation() {

			
	}
	
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
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public OrganismeFormation getOrganismeFormation() {
		return organismeFormation;
	}
	public void setOrganismeFormation(OrganismeFormation organismeFormation) {
		this.organismeFormation = organismeFormation;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
    
    
   
}
