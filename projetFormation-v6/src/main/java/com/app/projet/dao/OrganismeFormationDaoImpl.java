package com.app.projet.dao;

import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.exceptions.OrgUndeletableException;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrganismeFormationDaoImpl implements OrganismeFormationDao {

    @Autowired
    OrganismeFormationRepository orgRepo;

    @Override
    public OrganismeFormation create(OrganismeFormation organismeFormation) {
        return orgRepo.saveAndFlush(organismeFormation);
    }

    @Override
    public OrganismeFormation update(OrganismeFormation organismeFormation) throws StockNegatifException {
        OrganismeFormation org = orgRepo.findOne(organismeFormation.getId());

        org.setAdresse(organismeFormation.getAdresse());
        org.setDetailsFormation(organismeFormation.getDetailsFormation());
        org.setNom(organismeFormation.getNom());

        return orgRepo.save(org);
    }

    @Override
    public OrganismeFormation find(Long aLong) {
        return orgRepo.findOne(aLong);
    }

    @Override
    public List<OrganismeFormation> findAll() {
        return orgRepo.findAll();
    }

    @Override
    public boolean delete(OrganismeFormation organismeFormation) throws OrgUndeletableException {
    	
    	OrganismeFormation org1 = orgRepo.findOne(organismeFormation.getId());
    	List<DetailsFormation> list = org1.getDetailsFormation();
    	
    	if(list.size()!=0) {
    		throw new OrgUndeletableException ("ATTENTION IL EXISTE ENCORE  AU MOINS UNE FORMATION RELIEE A CET ORGANISME");
    }
        orgRepo.delete(orgRepo.findOne(organismeFormation.getId()));
        return false;
    }
}
