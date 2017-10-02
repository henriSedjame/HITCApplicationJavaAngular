package com.app.projet.dao;

import com.app.projet.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Administrateur, Long> {

    // SE CONNECTER
    @Query( "SELECT admin " +
            "FROM Administrateur admin " +
            "JOIN admin.identifiantsConnexion Id " +
            "WHERE Id.userName = ?1 AND Id.password = ?2" )
    Administrateur findByLoginAndMotDePasse(String userName, String password);
}
