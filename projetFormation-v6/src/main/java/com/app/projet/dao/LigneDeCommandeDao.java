package com.app.projet.dao;

import com.app.projet.entities.LigneDeCommande;
import com.app.projet.entities.Produit;

import java.util.List;

public interface LigneDeCommandeDao extends Dao<LigneDeCommande,Long> {

    List<LigneDeCommande> findByFicheCommande_Id(Long id);

    // TROUVER PRODUIT D'UNE LIGNE DE COMMANDE

    Produit findByLigneDeCommande(Long id);

}
