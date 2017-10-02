package com.app.projet.dao;

import com.app.projet.entities.FormationInformatique;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FormationInformatiqueDaoImpl implements FormationInformatiqueDao {

    @Autowired
    FormationInformatiqueRepository infoRepo;

    @Override
    public FormationInformatique create(FormationInformatique formationInformatique) {
        return infoRepo.saveAndFlush(formationInformatique);
    }

    @Override
    public FormationInformatique update(FormationInformatique formationInformatique) throws StockNegatifException {

        FormationInformatique prod = infoRepo.findOne(formationInformatique.getId());

        prod.setDesignation(formationInformatique.getDesignation());
        prod.setPrixUnitaire(formationInformatique.getPrixUnitaire());
        prod.setStock(formationInformatique.getStock());
        prod.setDisponibilite(formationInformatique.getDisponibilite());
        prod.setTechnoEnseigne(formationInformatique.getTechnoEnseigne());
        prod.setUrlImage(formationInformatique.getUrlImage());

        return infoRepo.save(prod);

    }

    @Override
    public FormationInformatique find(Long aLong) {
        return infoRepo.findOne(aLong);
    }

    @Override
    public List<FormationInformatique> findAll() {
        return infoRepo.findAll();
    }

    @Override
    public boolean delete(FormationInformatique formationInformatique) {
        infoRepo.delete(infoRepo.findOne(formationInformatique.getId()));
        return true;
    }
}
