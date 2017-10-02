package com.app.projet.dao;

import com.app.projet.entities.Commande;

import java.util.List;

public interface CommandeDao extends Dao<Commande, Long> {
    List<Commande> findByIdClient(Long id);
}
