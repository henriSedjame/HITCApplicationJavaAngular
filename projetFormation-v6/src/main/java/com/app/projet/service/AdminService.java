package com.app.projet.service;

import com.app.projet.dao.*;
import com.app.projet.entities.Administrateur;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import com.app.projet.exceptions.ClientNotFoundException;
import com.app.projet.exceptions.OrgUndeletableException;
import com.app.projet.exceptions.StockNegatifException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminDao                 adminDao;
    @Autowired
    ClientDao                clientDao;
    @Autowired
    CommandeDao              commandeDao;
    @Autowired
    FavorisDao               favorisDao;
    @Autowired
    FicheCommandeDao         ficheCommandeDao;
    @Autowired
    FormationArtistiqueDao   formationArtistiqueDao;
    @Autowired
    FormationInformatiqueDao formationInformatiqueDao;
    @Autowired
    FormationLinguistiqueDao formationLinguistiqueDao;
    @Autowired
    FormationSportiveDao     formationSportiveDao;
    @Autowired
    IdentifiantsConnexionDao identifiantsConnexionDao;
    @Autowired
    PanierDao                panierDao;
    @Autowired
    ProduitDao               produitDao;
    @Autowired
    LigneDeCommandeDao       ligneDeCommandeDao;
    @Autowired
    UtilisateurDao           utilisateurDao;
    @Autowired
    OrganismeFormationDao organismeFormationDao;
    @Autowired
    DetailsFormationDao detailsFormationDao;



    public Administrateur connecterAdmin(String login, String mdp) throws ClientNotFoundException {

        Administrateur admin = adminDao.findByLoginAndMotDePasse( login, mdp );

        if ( admin != null ) {
            return admin;
        } else {
            throw  new ClientNotFoundException( "IDENTIFIANTS ADMINISTRATEURS INCORRECTS VEUILLEZ REESSAYER!!!" );
        }

    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    public List<Produit> findByCategorie (String cat) {
        return produitDao.findAllByCategorie( cat );
    }

    public Produit updateProduit (Produit prod) throws StockNegatifException {
        return produitDao.update( prod );
    }

    public boolean supprimerProduit (Long id) throws OrgUndeletableException {
        return produitDao.delete( produitDao.find( id ) );
    }

    public List<OrganismeFormation> findOrgAll() {
        return organismeFormationDao.findAll();
    }

    public OrganismeFormation modifierOrg(OrganismeFormation org) throws StockNegatifException{
        return organismeFormationDao.update( org );
    }

    public boolean supprimerOrg(Long id) throws OrgUndeletableException {
        return organismeFormationDao.delete( organismeFormationDao.find( id ) );
    }

    public Produit findProduit(Long id ) {
        return produitDao.find( id );
    }



}
