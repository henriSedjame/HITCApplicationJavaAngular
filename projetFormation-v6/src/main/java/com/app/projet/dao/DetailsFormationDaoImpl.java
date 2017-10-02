package com.app.projet.dao;

import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DetailsFormationDaoImpl implements DetailsFormationDao {

    @Autowired
    DetailsFormationRepository detRepo;

    @Override
    public DetailsFormation create(DetailsFormation detailsFormation) {
        return detRepo.saveAndFlush(detailsFormation);
    }

    @Override
    public DetailsFormation update(DetailsFormation detailsFormation) throws StockNegatifException {

        DetailsFormation det = detRepo.findOne(detailsFormation.getId());

        det.setDescriptif(detailsFormation.getDescriptif());
        det.setDuree(detailsFormation.getDuree());
        det.setOrganismeFormation(detailsFormation.getOrganismeFormation());
        det.setProduit(detailsFormation.getProduit());

        return detRepo.save(det);
    }

    @Override
    public DetailsFormation find(Long aLong) {
        return detRepo.findOne(aLong);
    }

    @Override
    public List<DetailsFormation> findAll() {
        return detRepo.findAll();
    }

    @Override
    public boolean delete(DetailsFormation detailsFormation) {
        detRepo.delete(detRepo.findOne(detailsFormation.getId()));
        return false;
    }

    @Override public OrganismeFormation findOrg( String des ) {
        return detRepo.findOrg( des );
    }
}
