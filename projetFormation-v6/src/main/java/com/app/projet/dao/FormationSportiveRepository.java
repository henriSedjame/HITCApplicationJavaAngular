package com.app.projet.dao;

import com.app.projet.entities.FormationSportive;
import com.app.projet.entities.OrganismeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormationSportiveRepository extends JpaRepository<FormationSportive, Long> {

    //RECHERCHER PAR FOURCHETTE DE PRIX

    List<FormationSportive> findByPrixUnitaireBetween(double prix1, double prix2);

    // RECHERCHER PAR DESIGNATION

    FormationSportive findByDesignation(String designation);

    // RECHERCHER PAR ID


    // RECHERCHER PAR ORGANISME DE FORMATION
    @Query("SELECT form " +
            "FROM FormationSportive form " +
            "JOIN form.detailsFormation det " +
            "WHERE det.organismeFormation = ?1")
    FormationSportive findByOrganisme(OrganismeFormation org);

    // RECHERCHER PAR NOM ORGANISME DE FORMATION
    @Query("SELECT form " +
            "FROM FormationSportive form " +
            "JOIN form.detailsFormation det " +
            "JOIN det.organismeFormation org " +
            "WHERE org.nom = ?1")
    FormationSportive findByOrganisme(String orgNom);

    // RECHERCHER PAR DUREE
    @Query("SELECT form " +
            "FROM FormationSportive form " +
            "JOIN form.detailsFormation det " +
            "WHERE det.duree = ?1")
    FormationSportive findByDuree(int duree);
}
