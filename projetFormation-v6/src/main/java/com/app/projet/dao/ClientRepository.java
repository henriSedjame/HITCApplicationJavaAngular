package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientRepository extends JpaRepository<Client, Long> {

    // SE CONNECTER
    @Query( "SELECT client " +
            "FROM Client client " +
            "JOIN client.identifiantsConnexion Id " +
            "WHERE Id.userName = ?1 AND Id.password = ?2" )
    Client findByLoginAndMotDePasse(String userName, String password);

    Client findByIdentifiantsConnexionUserName(String userName);

    // TROUVER UN CLIENT PAR EMAIL

    Client findByEmail(String email);

    // AFFICHER PANIER
    @Query("SELECT pan " +
            "FROM Panier pan " +
            "WHERE pan.client = ?1 ")
    Panier findPanier(Client client);

    //TROUVER PAR NOM

    Client findByNom(String nom);
}
