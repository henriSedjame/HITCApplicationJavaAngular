package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.Panier;

public interface PanierDao extends Dao<Panier, Long> {
    Panier findByClient_Nom(String nom);
}
