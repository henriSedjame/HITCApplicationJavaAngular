package com.app.projet.dao;

import com.app.projet.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CommandeDaoImpl implements CommandeDao {

    @Autowired
    CommandeRepository commandeRepo;

    @Override
    public Commande create(Commande commande) {
        return commandeRepo.saveAndFlush(commande);
    }

    @Override
    public Commande update(Commande commande) {
        Commande com = commandeRepo.findOne(commande.getId());

        com.setLigneDeCommandes(commande.getLigneDeCommandes());
        com.setPrixTotal(commande.getPrixTotal());
        com.setDate(commande.getDate());
        com.setIdClient(commande.getIdClient());

        return commandeRepo.save(com);
    }

    @Override
    public Commande find(Long aLong) {
        return commandeRepo.findOne(aLong);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepo.findAll();
    }

    @Override
    public boolean delete(Commande commande) {
        commandeRepo.delete(commandeRepo.findOne(commande.getId()));
        return true;
    }

    @Override
    public List<Commande> findByIdClient(Long id) {
        return commandeRepo.findByIdClient(id);
    }
}
