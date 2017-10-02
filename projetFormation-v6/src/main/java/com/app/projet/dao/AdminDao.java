package com.app.projet.dao;

import com.app.projet.entities.Administrateur;

public interface AdminDao extends Dao<Administrateur,Long> {
    Administrateur findByLoginAndMotDePasse(String userName, String password);
}
