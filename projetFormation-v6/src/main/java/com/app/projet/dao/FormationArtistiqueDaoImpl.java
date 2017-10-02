package com.app.projet.dao;

import com.app.projet.entities.FormationArtistique;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FormationArtistiqueDaoImpl implements FormationArtistiqueDao {

    @Autowired
    FormationArtistiqueRepository artRepo;

    @Override
    public FormationArtistique create(FormationArtistique formationArtistique) {
        return artRepo.saveAndFlush(formationArtistique);
    }

    @Override
    public FormationArtistique update(FormationArtistique formationArtistique) throws StockNegatifException {

        FormationArtistique prod = artRepo.findOne(formationArtistique.getId());

        prod.setDesignation(formationArtistique.getDesignation());
        prod.setPrixUnitaire(formationArtistique.getPrixUnitaire());
        prod.setStock(formationArtistique.getStock());
        prod.setDisponibilite(formationArtistique.getDisponibilite());
        prod.setArtEnseigne(formationArtistique.getArtEnseigne());
        prod.setUrlImage(formationArtistique.getUrlImage());

        return artRepo.save(prod);

    }

    @Override
    public FormationArtistique find(Long aLong) {
        return artRepo.findOne(aLong);
    }

    @Override
    public List<FormationArtistique> findAll() {
        return artRepo.findAll();
    }

    @Override
    public boolean delete(FormationArtistique formationArtistique) {
        artRepo.delete(artRepo.findOne(formationArtistique.getId()));
        return true;
    }
}
