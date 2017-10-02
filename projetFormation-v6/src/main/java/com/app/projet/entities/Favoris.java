package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Favoris  {

	@Version
	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// ATTRIBUTS

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "Favoris_Produit", joinColumns = {
            @JoinColumn( name = "id_favoris" ) }, inverseJoinColumns = {
            @JoinColumn( name = "id_produit" ) } )
	//@JsonBackReference(value = "prod-fav")
	@Column(unique = true)
    private List<Produit> produits = new ArrayList<>();
	
    @OneToOne(mappedBy = "favoris")
	@JsonBackReference(value = "client-favoris")
	private Client client;

	// CONSTRUCTEURS

    public Favoris() {

    }

    public Favoris( List<Produit> produits, Client client) {
		this.produits = produits;
		this.client = client;
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
