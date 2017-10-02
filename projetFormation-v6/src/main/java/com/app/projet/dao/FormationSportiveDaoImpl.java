package com.app.projet.dao;

import com.app.projet.entities.FormationSportive;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FormationSportiveDaoImpl implements FormationSportiveDao {

    @Autowired
    FormationSportiveRepository sportRepo;


    @Override
    public FormationSportive create(FormationSportive formationSportive) {
        return sportRepo.saveAndFlush(formationSportive);
    }

    @Override
    public FormationSportive update(FormationSportive formationSportive) throws StockNegatifException {

        FormationSportive prod = sportRepo.findOne(formationSportive.getId());

        prod.setDesignation(formationSportive.getDesignation());
        prod.setPrixUnitaire(formationSportive.getPrixUnitaire());
        prod.setStock(formationSportive.getStock());
        prod.setDisponibilite(formationSportive.getDisponibilite());
        prod.setSportEnseigne(formationSportive.getSportEnseigne());
        prod.setUrlImage(formationSportive.getUrlImage());

        return sportRepo.save(prod);

    }

    @Override
    public FormationSportive find(Long aLong) {
        return sportRepo.findOne(aLong);
    }

    @Override
    public List<FormationSportive> findAll() {
        return sportRepo.findAll();
    }

    @Override
    public boolean delete(FormationSportive formationSportive) {
        sportRepo.delete(sportRepo.findOne(formationSportive.getId()));
        return true;
    }
}
