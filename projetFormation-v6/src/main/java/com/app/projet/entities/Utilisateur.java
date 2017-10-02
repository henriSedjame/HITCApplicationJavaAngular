package com.app.projet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity       
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public abstract class Utilisateur {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long id;

    // ATTRIBUTS
    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 10)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "id_identifiants_connexion" )
    @JsonManagedReference(value = "utilisateur-identifiants")
    private IdentifiantsConnexion identifiantsConnexion;

    @Embedded
    private Adresse adresse;

    // CONSTRUCTEURS

    public Utilisateur(String nom, String prenom, String email, Date dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }
    public Utilisateur(String nom, String prenom, String email, Date dateNaissance, Adresse adresse,IdentifiantsConnexion identifiantsConnexion) {
        
    		this(nom, prenom, email, dateNaissance,adresse);
    		this.identifiantsConnexion =  identifiantsConnexion;
    }

    public Utilisateur(String nom, String prenom, String email, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    public Utilisateur() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public IdentifiantsConnexion getIdentifiantsConnexion() {
        return identifiantsConnexion;
    }

    public void setIdentifiantsConnexion(IdentifiantsConnexion identifiants) {
        this.identifiantsConnexion = identifiants;
    }
}
