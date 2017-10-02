package com.app.projet.dao;

import com.app.projet.entities.Favoris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FavorisDaoImpl implements FavorisDao {

    @Autowired
    FavorisRepository favRepo;

    @Override
    public Favoris create(Favoris favoris) {
        return favRepo.saveAndFlush(favoris);
    }

    @Override
    public Favoris update(Favoris favoris) {

        Favoris fav = favRepo.findOne(favoris.getId());
        fav.setProduits(favoris.getProduits());
        fav.setClient(favoris.getClient());

        return favRepo.save(fav);
    }

    @Override
    public Favoris find(Long aLong) {
        return favRepo.findOne(aLong);
    }

    @Override
    public List<Favoris> findAll() {
        return favRepo.findAll();
    }

    @Override
    public boolean delete(Favoris favoris) {
        favRepo.delete(favRepo.findOne(favoris.getId()));
        return true;
    }

    @Override
    public Favoris findByClient_Nom(String nom) {
        return favRepo.findByClient_Nom(nom);
    }
}
