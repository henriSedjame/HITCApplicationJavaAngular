package com.app.projet.entities;

import com.app.projet.exceptions.StockNegatifException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Produit {
	
	@Version       
	private int Version;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )   
	private Long id;

	// ATTRIBUTS
	
	@Column(length = 50, unique = true)
    private String designation;

	private int stock;

	private boolean disponibilite;

	private double prixUnitaire;

	private String categorie;

	private String urlImage;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "id_details_formation")
	@JsonManagedReference(value = "prod-det")
	private DetailsFormation detailsFormation;

	@OneToMany( mappedBy = "produit", fetch = FetchType.LAZY)
	@JsonManagedReference(value = "ligne-prod")
	private List<LigneDeCommande> LigneDeCommandes = new ArrayList<>();

	@ManyToMany( mappedBy = "produits", fetch = FetchType.EAGER )
	//@JsonManagedReference(value = "prod-fav")
    @JsonIgnore
    private List<Favoris> favoris = new ArrayList<>();


	// CONSTRUCTEURS

	public Produit() {

        if ( this instanceof FormationSportive ){
            this.categorie = "SPORTIVE";
        }
        if ( this instanceof FormationArtistique ){
            this.categorie = "ARTISTIQUE";
        }
        if ( this instanceof FormationInformatique ) {
            this.categorie =  "INFORMATIQUE";
        }
        if ( this instanceof FormationLinguistique ) {
            this.categorie =  "LINGUISTIQUE";
        }

	}

	public Produit( String designation, int stock, boolean disponibilite, double prixUnitaire) {
		this();

		this.designation = designation;
		this.stock = stock;
		this.disponibilite = disponibilite;
		this.prixUnitaire = prixUnitaire;
	}

	public Produit( String designation, int stock, boolean disponibilite, double prixUnitaire, String urlImage) {
		this();

		this.designation = designation;
		this.stock = stock;
		this.disponibilite = disponibilite;
		this.prixUnitaire = prixUnitaire;
		this.urlImage = urlImage;
	}

	public Produit( String designation, int stock, boolean disponibilite, double prixUnitaire, DetailsFormation detailsFormation,String urlImage) {
		this();

		this.designation = designation;
		this.stock = stock;
		this.disponibilite = disponibilite;
		this.prixUnitaire = prixUnitaire;
		this.detailsFormation = detailsFormation;
		this.urlImage = urlImage;


	}

	// GETTERS SETTERS

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) throws StockNegatifException{
		
	    if (stock >= 0){
            this.stock = stock;
        }else{
	        throw new StockNegatifException("LE STOCK NE PEUT PAS ETRE NEGATIF !!!");
        }

	}


	public boolean getDisponibilite() {

        if (this.stock == 0){
            return false;
        }else{
            return true;
        }

	}


	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	public double getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getVersion() {
		return Version;
	}


	public void setVersion(int version) {
		Version = version;
	}

	//@JsonIgnore
	public DetailsFormation getDetailsFormation() {
		return detailsFormation;
	}


	public void setDetailsFormation(DetailsFormation detailsFormation) {
		this.detailsFormation = detailsFormation;
	}

	//@JsonIgnore
    public List<LigneDeCommande> getLigneDeCommandes() {
        return LigneDeCommandes;
    }

    public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
        LigneDeCommandes = ligneDeCommandes;
    }

    //@JsonIgnore
    public List<Favoris> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Favoris> favoris) {
        this.favoris = favoris;
    }

    public String getCategorie() {

        return categorie;

    }

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}