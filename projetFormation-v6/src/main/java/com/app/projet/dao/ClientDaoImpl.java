package com.app.projet.dao;

import com.app.projet.entities.Client;
import com.app.projet.entities.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    @Autowired
    ClientRepository clientRepo;

    @Override
    public Client create(Client client) {

        return clientRepo.saveAndFlush(client);
    }

    @Override
    public Client update(Client client) {

        Client cli =clientRepo.findOne(client.getId());

        if ( cli != null ) {


            cli.setNom(client.getNom());
            cli.setPrenom(client.getPrenom());
            cli.setAdresse(client.getAdresse());
            cli.setDateNaissance(client.getDateNaissance());
            cli.setEmail(client.getEmail());
            cli.setIdentifiantsConnexion(client.getIdentifiantsConnexion());
            cli.setFavoris(client.getFavoris());
        }

        return clientRepo.save(cli);
    }

    @Override
    public Client find(Long aLong) {

        return clientRepo.findOne(aLong);
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public boolean delete(Client client) {
        clientRepo.delete(clientRepo.findOne(client.getId()));
        return true ;
    }

    @Override
    public Client findByLoginAndMotDePasse(String userName, String password) {
        return clientRepo.findByLoginAndMotDePasse(userName, password);
    }

    @Override
    public Client findByEmail(String email){

        return clientRepo.findByEmail( email );
    }

    @Override
    public Panier findPanier(Client client) {

        return clientRepo.findPanier(client);
    }

    @Override
    public Client findByLogin(String login) {
        return clientRepo.findByIdentifiantsConnexionUserName(login);
    }

    @Override
    public Client findByNom(String nom) {

        return clientRepo.findByNom(nom);
    }
}
