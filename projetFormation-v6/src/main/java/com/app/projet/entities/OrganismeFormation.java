package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class OrganismeFormation  {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    
    // ATTRIBUTS

    @Column(length = 50, unique = true)
    private String nom;

    @OneToMany( mappedBy = "organismeFormation", cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "org-det")
    private List<DetailsFormation> detailsFormation = new ArrayList<>();

    @Embedded
    private Adresse adresse;
    
    // CONSTRUCTEURS

	public OrganismeFormation(String nom, Adresse adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

	public OrganismeFormation(String nom) {
		this.nom = nom;
	}

	public OrganismeFormation() {
		super();
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<DetailsFormation> getDetailsFormation() {
		return detailsFormation;
	}
	public void setDetailsFormation(List<DetailsFormation> detailsFormation) {
		this.detailsFormation = detailsFormation;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
    
    
}
