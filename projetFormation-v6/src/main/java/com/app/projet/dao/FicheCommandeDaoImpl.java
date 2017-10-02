package com.app.projet.dao;

import com.app.projet.entities.FicheCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class FicheCommandeDaoImpl implements FicheCommandeDao {

    @Autowired
    FicheCommandeRepository fCRepo;

    @Override
    public FicheCommande create(FicheCommande ficheCommande) {
        return fCRepo.saveAndFlush(ficheCommande);
    }

    @Override
    public FicheCommande update(FicheCommande ficheCommande) {

        return fCRepo.save(ficheCommande);
    }

    @Override
    public FicheCommande find(Long aLong) {
        return fCRepo.findOne(aLong);
    }

    @Override
    public List<FicheCommande> findAll() {
        return fCRepo.findAll();
    }

    @Override
    public boolean delete(FicheCommande ficheCommande) {
        fCRepo.delete(fCRepo.findOne(ficheCommande.getId()));
        return true;
    }
}
