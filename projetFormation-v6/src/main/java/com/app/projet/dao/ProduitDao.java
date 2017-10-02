package com.app.projet.dao;

import com.app.projet.entities.CategorieProduit;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;

import java.util.List;

public interface ProduitDao extends Dao<Produit, Long> {


    //RECHERCHER PAR FOURCHETTE DE PRIX

    List<Produit> findByPrixUnitaireBetween(double prix1, double prix2);

    // RECHERCHER PAR DESIGNATION

    Produit findByDesignation(String designation);

    // RECHERCHER PAR CATEGORIE

    List<Produit> findAllByCategorie(String categorieProduit);

    // RECHERCHER PAR ORGANISME DE FORMATION

    List<Produit> findByOrganisme(OrganismeFormation org);

    // RECHERCHER PAR NOM ORGANISME DE FORMATION

    List<Produit> findByOrganisme(String orgNom);

    // RECHERCHER PAR DUREE

    List<Produit> findByDuree(int duree);



}
