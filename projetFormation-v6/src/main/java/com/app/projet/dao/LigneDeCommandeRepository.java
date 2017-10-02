package com.app.projet.dao;

import com.app.projet.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.projet.entities.LigneDeCommande;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LigneDeCommandeRepository extends JpaRepository<LigneDeCommande, Long> {

    List<LigneDeCommande> findByFicheCommande_Id(Long id);

    // TROUVER PRODUIT D'UNE LIGNE DE COMMANDE

    @Query("SELECT lc.produit "
            + " FROM LigneDeCommande lc "
            + "WHERE lc.id = ?1")
    Produit findByLigneDeCommande(Long id);

}
