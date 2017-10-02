package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class LigneDeCommande {

    @Version
    private int Version;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long id;

    // ATTRIBUTS

	private int quantite;

	@ManyToOne
	@JoinColumn(name="id_produit")
	@JsonBackReference(value = "ligne-prod")
    private Produit produit;

	@ManyToOne()
    @JoinColumn(name = "id_fiche_commande")
	@JsonBackReference(value = "fiche-ligne")
    private FicheCommande ficheCommande;

    // CONSTRUCTEURS
	
	public LigneDeCommande(int quantite, Produit produit, FicheCommande ficheCommande) {
		this.quantite = quantite;
		this.produit = produit;
		this.ficheCommande = ficheCommande;

	}

	public LigneDeCommande(int quantite, Produit produit) {
		this.quantite = quantite;
		this.produit = produit;
	}

	public LigneDeCommande() {
		super();
	}

    // GETTERS SETTERS

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public FicheCommande getFicheCommande() {
		return ficheCommande;
	}

	public void setFicheCommande(FicheCommande ficheCommande) {
		this.ficheCommande = ficheCommande;
		// this.ficheCommande.getLigneDeCommandes().add( this );
	}

    public int getVersion() {
        return Version;
    }

    public void setVersion(int version) {
        Version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
