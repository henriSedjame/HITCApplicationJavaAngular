package com.app.projet.dao;

import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.OrganismeFormation;

public interface DetailsFormationDao extends Dao<DetailsFormation, Long> {
    OrganismeFormation findOrg(String des);
}
