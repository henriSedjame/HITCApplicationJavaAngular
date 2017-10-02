package com.app.projet.dao;

import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.OrganismeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailsFormationRepository extends JpaRepository<DetailsFormation, Long> {

    @Query("SELECT det.organismeFormation "
            + "FROM DetailsFormation det "
            + "JOIN det.produit prod "
            + "WHERE prod.designation =?1 ")
    OrganismeFormation findOrg(String des);
}
