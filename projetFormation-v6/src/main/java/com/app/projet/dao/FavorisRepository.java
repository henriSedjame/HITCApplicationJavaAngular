package com.app.projet.dao;

import com.app.projet.entities.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorisRepository extends JpaRepository<Favoris, Long> {

    Favoris findByClient_Nom(String nom);
}
