package com.app.projet.dao;

import com.app.projet.entities.IdentifiantsConnexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class IdentifiantsConnexionDaoImpl implements IdentifiantsConnexionDao {

    @Autowired
    IdentifiantsConnexionRepository idRepo;

    @Override
    public IdentifiantsConnexion create(IdentifiantsConnexion identifiantsConnexion) {
        return idRepo.saveAndFlush(identifiantsConnexion);
    }

    @Override
    public IdentifiantsConnexion update(IdentifiantsConnexion identifiantsConnexion) {

        IdentifiantsConnexion id = idRepo.findOne(identifiantsConnexion.getId());

        id.setPassword(identifiantsConnexion.getPassword());
        id.setUserName(identifiantsConnexion.getUserName());
        id.setUtilisateur(identifiantsConnexion.getUtilisateur());

        return idRepo.save(id);
    }

    @Override
    public IdentifiantsConnexion find(Long aLong) {
        return idRepo.findOne(aLong);
    }

    @Override
    public List<IdentifiantsConnexion> findAll() {
        return idRepo.findAll();
    }

    @Override
    public boolean delete(IdentifiantsConnexion identifiantsConnexion) {
        idRepo.delete(idRepo.findOne(identifiantsConnexion.getId()));
        return true;
    }


}
