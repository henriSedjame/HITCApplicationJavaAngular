package com.app.projet.dao;

import com.app.projet.entities.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

    @Autowired
    AdminRepository adminRepo;

    @Override
    public Administrateur create(Administrateur administrateur) {
        return adminRepo.saveAndFlush(administrateur);
    }

    @Override
    public Administrateur update(Administrateur administrateur) {

        Administrateur admin = adminRepo.findOne(administrateur.getId());

        admin.setNom(administrateur.getNom());
        admin.setPrenom(administrateur.getPrenom());
        admin.setAdresse(administrateur.getAdresse());
        admin.setDateNaissance(administrateur.getDateNaissance());
        admin.setEmail(administrateur.getEmail());
        admin.setIdentifiantsConnexion(administrateur.getIdentifiantsConnexion());

        return adminRepo.save(admin);
    }

    @Override
    public Administrateur find(Long aLong) {
        return adminRepo.findOne(aLong);
    }

    @Override
    public List<Administrateur> findAll() {
        return adminRepo.findAll();
    }

    @Override
    public boolean delete(Administrateur administrateur) {

        adminRepo.delete(adminRepo.findOne(administrateur.getId()));

        return true;
    }

    @Override
    public Administrateur findByLoginAndMotDePasse(String userName, String password) {
        return adminRepo.findByLoginAndMotDePasse(userName, password);
    }
}
