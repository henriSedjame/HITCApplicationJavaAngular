package com.app.projet.dao;

import com.app.projet.entities.CategorieProduit;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    //RECHERCHER PAR FOURCHETTE DE PRIX

    List<Produit> findByPrixUnitaireBetween(double prix1, double prix2);

    // RECHERCHER PAR DESIGNATION

    Produit findByDesignation(String designation);

    // RECHERCHER PAR CATEGORIE

    List<Produit> findAllByCategorie(String categorieProduit);

    // RECHERCHER PAR ORGANISME DE FORMATION
    @Query("SELECT prod " +
            "FROM Produit prod " +
            "JOIN prod.detailsFormation det " +
            "WHERE det.organismeFormation = ?1")
    List<Produit> findByOrganisme(OrganismeFormation org);

    // RECHERCHER PAR NOM ORGANISME DE FORMATION
    @Query("SELECT prod " +
            "FROM Produit prod " +
            "JOIN prod.detailsFormation det " +
            "JOIN det.organismeFormation org " +
            "WHERE org.nom = ?1")
    List<Produit> findByOrganisme(String orgNom);

    // RECHERCHER PAR DUREE
    @Query("SELECT prod " +
            "FROM Produit prod " +
            "JOIN prod.detailsFormation det " +
            "WHERE det.duree = ?1")
    List<Produit> findByDuree(int duree);



}


