package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    Panier findByClient_Nom(String nom);
}
