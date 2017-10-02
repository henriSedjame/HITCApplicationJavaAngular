package com.app.projet.dao;


import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProduitDaoImpl implements ProduitDao {

    @Autowired
    ProduitRepository produitRepo;

    @Override
    public Produit create(Produit produit) {
        return produitRepo.saveAndFlush(produit);
    }

    @Override
    public Produit update(Produit produit) throws StockNegatifException{
        Produit prod = produitRepo.findOne(produit.getId());

        prod.setDesignation(produit.getDesignation());
        prod.setPrixUnitaire(produit.getPrixUnitaire());
        prod.setStock(produit.getStock());
        prod.setDisponibilite(produit.getDisponibilite());
        prod.setDetailsFormation(produit.getDetailsFormation());
        prod.setLigneDeCommandes(produit.getLigneDeCommandes());
        prod.setFavoris(produit.getFavoris());
        prod.setUrlImage(produit.getUrlImage());

        return produitRepo.save(prod);
    }

    @Override
    public Produit find(Long aLong) {
        return produitRepo.findOne(aLong);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepo.findAll();
    }

    @Override
    public boolean delete(Produit produit) {
        produitRepo.delete(produitRepo.findOne(produit.getId()));
        return true;
    }

    @Override
    public List<Produit> findByPrixUnitaireBetween(double prix1, double prix2) {
        return produitRepo.findByPrixUnitaireBetween(prix1, prix2);
    }

    @Override
    public Produit findByDesignation(String designation) {
        return produitRepo.findByDesignation(designation);
    }

    @Override
    public List<Produit> findByOrganisme(OrganismeFormation org) {
        return produitRepo.findByOrganisme(org);
    }

    @Override
    public List<Produit> findByOrganisme(String orgNom) {
        return produitRepo.findByOrganisme(orgNom);
    }

    @Override
    public List<Produit> findByDuree(int duree) {
        return produitRepo.findByDuree(duree);
    }

    @Override
    public List<Produit> findAllByCategorie( String categorieProduit ) {
        return produitRepo.findAllByCategorie( categorieProduit );
    }


}
