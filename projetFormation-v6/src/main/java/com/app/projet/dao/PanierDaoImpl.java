package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.LigneDeCommande;
import com.app.projet.entities.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PanierDaoImpl implements PanierDao {

    @Autowired
    PanierRepository panierRepo;

    @Override
    public Panier create(Panier panier) {
        return panierRepo.saveAndFlush(panier);
    }

    @Override
    public Panier update(Panier panier) {

        Panier pan = panierRepo.findOne(panier.getId());

        pan.setLigneDeCommandes( panier.getLigneDeCommandes() );
        pan.setPrixTotal(panier.getPrixTotal());
        pan.setClient(panier.getClient());

        return panierRepo.save(pan);
    }

    @Override
    public Panier find(Long aLong) {
        return panierRepo.findOne(aLong);
    }

    @Override
    public List<Panier> findAll() {
        return panierRepo.findAll();
    }

    @Override
    public boolean delete(Panier panier) {
        panierRepo.delete(panierRepo.findOne(panier.getId()));
        return true;
    }

    @Override
    public Panier findByClient_Nom(String nom) {
        return panierRepo.findByClient_Nom(nom);
    }
}
