package com.app.projet.dao;

import com.app.projet.entities.Utilisateur;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UtilisateurDaoImpl implements UtilisateurDao {

    @Autowired
    UtilisateurRepository uRepo;

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return uRepo.saveAndFlush(utilisateur);
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) throws StockNegatifException {
        Utilisateur util = uRepo.findOne(utilisateur.getId());

        util.setAdresse(utilisateur.getAdresse());
        util.setDateNaissance(utilisateur.getDateNaissance());
        util.setEmail(utilisateur.getEmail());
        util.setIdentifiantsConnexion(utilisateur.getIdentifiantsConnexion());
        util.setNom(utilisateur.getNom());
        util.setPrenom(utilisateur.getPrenom());

        return uRepo.save(util);
    }

    @Override
    public Utilisateur find(Long aLong) {
        return uRepo.findOne(aLong);
    }

    @Override
    public List<Utilisateur> findAll() {
        return uRepo.findAll();
    }

    @Override
    public boolean delete(Utilisateur utilisateur) {
        uRepo.delete(uRepo.findOne(utilisateur.getId()));
        return true;
    }
}
