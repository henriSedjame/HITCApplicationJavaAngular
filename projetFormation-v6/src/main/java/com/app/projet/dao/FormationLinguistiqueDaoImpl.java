package com.app.projet.dao;

import com.app.projet.entities.FormationLinguistique;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FormationLinguistiqueDaoImpl implements FormationLinguistiqueDao {

    @Autowired
    FormationLinguistiqueRepository lingRepo;


    @Override
    public FormationLinguistique create(FormationLinguistique formationLinguistique) {
        return lingRepo.saveAndFlush(formationLinguistique);
    }

    @Override
    public FormationLinguistique update(FormationLinguistique formationLinguistique) throws StockNegatifException {

        FormationLinguistique prod = lingRepo.findOne(formationLinguistique.getId());

        prod.setDesignation(formationLinguistique.getDesignation());
        prod.setPrixUnitaire(formationLinguistique.getPrixUnitaire());
        prod.setStock(formationLinguistique.getStock());
        prod.setDisponibilite(formationLinguistique.getDisponibilite());
        prod.setLanguesEnseigne(formationLinguistique.getLanguesEnseigne());
        prod.setUrlImage(formationLinguistique.getUrlImage());

        return lingRepo.save(prod);

    }

    @Override
    public FormationLinguistique find(Long aLong) {
        return lingRepo.findOne(aLong);
    }

    @Override
    public List<FormationLinguistique> findAll() {
        return lingRepo.findAll();
    }

    @Override
    public boolean delete(FormationLinguistique formationLinguistique) {
        lingRepo.delete(lingRepo.findOne(formationLinguistique.getId()));
        return true;
    }
}
