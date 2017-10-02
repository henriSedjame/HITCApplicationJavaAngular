package com.app.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
public class IdentifiantsConnexion {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    // ATTRIBUTS

    @Column(length = 50, unique = true)
    private String userName;

    @Column(length = 25)
    private String password;

    @OneToOne(mappedBy = "identifiantsConnexion")
    @JsonBackReference(value = "utilisateur-identifiants")
    private Utilisateur utilisateur;

    // CONSTRUCTEURS

    public IdentifiantsConnexion(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public IdentifiantsConnexion() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
