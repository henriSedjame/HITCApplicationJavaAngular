package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.Panier;

public interface ClientDao extends Dao<Client, Long> {
    Client findByLoginAndMotDePasse(String userName, String password);

    Client findByLogin(String login);

    Client findByEmail(String email);

    Client findByNom(String nom);

    Panier findPanier(Client client);

}
