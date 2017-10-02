package com.app.projet.dao;

import com.app.projet.entities.Favoris;

public interface FavorisDao extends Dao<Favoris, Long> {
    Favoris findByClient_Nom(String nom);
}
