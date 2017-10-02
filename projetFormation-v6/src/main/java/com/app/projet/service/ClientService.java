package com.app.projet.service;

import com.app.projet.dao.*;
import com.app.projet.entities.*;
import com.app.projet.exceptions.*;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    // IMJECTION DE DAO

    @Autowired
    AdminDao adminDao;
    @Autowired
    ClientDao clientDao;
    @Autowired
    CommandeDao commandeDao;
    @Autowired
    FavorisDao favorisDao;
    @Autowired
    FicheCommandeDao ficheCommandeDao;
    @Autowired
    FormationArtistiqueDao formationArtistiqueDao;
    @Autowired
    FormationInformatiqueDao formationInformatiqueDao;
    @Autowired
    FormationLinguistiqueDao formationLinguistiqueDao;
    @Autowired
    FormationSportiveDao formationSportiveDao;
    @Autowired
    IdentifiantsConnexionDao identifiantsConnexionDao;
    @Autowired
    PanierDao panierDao;
    @Autowired
    ProduitDao produitDao;
    @Autowired
    LigneDeCommandeDao ligneDeCommandeDao;
    @Autowired
    UtilisateurDao utilisateurDao;
    @Autowired
    OrganismeFormationDao organismeFormationDao;
    @Autowired
    DetailsFormationDao detailsFormationDao;


// ------------------------------------------- CONNEXION --------------------------------------------

    //SE CONNECTER ---> OK

    public Client seConnecter(String login, String password, ArrayList<LigneDeCommande> panierVirtuel ) throws ClientNotFoundException {

//        final String     ALGO_CHIFFREMENT   = "SHA-256";
//
//        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
//        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
//        passwordEncryptor.setPlainDigest( false );

        Client client = clientDao.findByLoginAndMotDePasse( login, password );


        if (client == null) {

            throw new ClientNotFoundException("LE LOGIN RENSEIGNE EST ERRONNE. VEUILLEZ REESSAYER");
        }

        for ( LigneDeCommande lc : client.getPanier().getLigneDeCommandes()) {
            panierVirtuel.add(lc);
        }

        return client;

//        } else {
//            String encryptedPassword = client.getIdentifiantsConnexion().getPassword();
//
//            if ( passwordEncryptor.checkPassword( password, encryptedPassword ) == false ) {
//
//                throw new ClientNotFoundException( "LE MOT DE PASSE RENSEIGNE EST INCORRECT" );
//            }
//
//            return client;
//        }
    }


    // SE DECONNECTER ---> OK

    public void seDeconnecter(HttpServletRequest req, ArrayList<LigneDeCommande> panierVirtuel, Client clientConnecte) throws StockNegatifException {

        clientConnecte= clientDao.find(clientConnecte.getId());
        Panier panierClient = clientConnecte.getPanier();


        for (LigneDeCommande lc: panierVirtuel) {

            lc.setProduit(produitDao.find(lc.getProduit().getId()));
            lc.setFicheCommande(panierDao.find(clientConnecte.getPanier().getId()));
            ligneDeCommandeDao.create(lc);

            panierClient.getLigneDeCommandes().add(lc);

        }

        panierDao.update(panierClient);

    }

    // S'INSCRIRE ---> OK

    public Client sInscrire(Client client) throws ClientAlreadyExisting {

        if (clientDao.findByEmail(client.getEmail()) != null) {
            throw new ClientAlreadyExisting("UN COMPTE EXISTE DEJA AVEC L'ADRESSE E-MAIL RENSEIGNE !!!");
        } else {

//           final String     ALGO_CHIFFREMENT   = "SHA-256";
//           ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
//           passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
//           passwordEncryptor.setPlainDigest( false );
//           String encryptedPassword = passwordEncryptor.encryptPassword( client.getIdentifiantsConnexion().getPassword() );
//
//           client.getIdentifiantsConnexion().setPassword(encryptedPassword);

            return clientDao.create(client);

        }

    }

    //MODIFIER PROFIL CLIENT

    public Client modifClient(Client client) throws StockNegatifException {
        return clientDao.update(client);
    }


// ------------------------------------------- PRODUITS --------------------------------------------

    // VISUALISER TOUS LES PRODUITS ---> OK

    public List<Produit> rechercherTousLesProduits() {
        return produitDao.findAll();
    }

    //VISUALISER TOUS LES PRODUITS D'UNE CATEGORIE ---> OK

    public List<Produit> rechercherParCategorie(String categorie) {
        return produitDao.findAllByCategorie(categorie);
    }

    //RECHERCHER PAR FOURCHETTE DE PRIX ---> OK

    public List<Produit> rechercherParFourchetteDePrix(double prix1, double prix2) {
        return produitDao.findByPrixUnitaireBetween(prix1, prix2);
    }

    // RECHERCHER PAR DESIGNATION ---> OK

    public Produit rechercherParDesignation(String designation) {
        return produitDao.findByDesignation(designation);
    }

    // RECHERCHER PAR ORGANISME ---> OK

    public List<Produit> rechercherParOrganisme(OrganismeFormation org) {
        return produitDao.findByOrganisme(org);
    }

    // RECHERCHER PAR NOM ORGANISME DE FORMATION ---> OK

    public List<Produit> rechercherParOrganisme(String orgNom) {
        return produitDao.findByOrganisme(orgNom);
    }

    // RECHERCHER PAR DUREE ---> OK

    public List<Produit> rechercherParDuree(int duree) throws EmptyResponseException {
        List<Produit> list = produitDao.findByDuree(duree);

        if (list.size() == 0) {
            throw new EmptyResponseException("AUCUNE FORMATION NE CORRESPOND A VOS CRITERES DE SELECTION");
        }
        return list;
    }

    public OrganismeFormation rechercherOrganisme( String des ) {
        return detailsFormationDao.findOrg( des );
    }

    // RECHERCHER D'UNE LIGNE DE COMMANDE

    public Produit rechercherProduitParLigneCommande(Long id) {
        return ligneDeCommandeDao.findByLigneDeCommande( id );
    }

// ------------------------------------------- PANIER --------------------------------------------

    // AFFICHER PANIER ---> OK

    public Panier afficherPanier(String nom) {
        Panier panier = panierDao.findByClient_Nom(nom);

        List<LigneDeCommande> list = panier.getLigneDeCommandes();
        double prix = panier.getPrixTotal();

        for (LigneDeCommande ligneDeCommande : list) {
            prix += ( ligneDeCommande.getProduit().getPrixUnitaire() * ligneDeCommande.getQuantite() );
        }

        panier.setPrixTotal( prix );
        return panier;
    }

    // AJOUTER PRODUIT AU PANIER --->  COTE ANGULAR
    public Panier ajouterProduitAuPanier(Long id, String des, LigneDeCommande ligneDeCommande) throws StockNegatifException {
        Panier panier = panierDao.find(id);
        Produit prod = produitDao.findByDesignation(des);

        ligneDeCommande.setProduit(prod);
        ligneDeCommande.setFicheCommande(panier);
        ligneDeCommande = ligneDeCommandeDao.create(ligneDeCommande);

        return panierDao.update(panier);
    }

    // VIDER PANIER  --->  COTE ANGULAR

    public Panier viderPanier(Long id) throws StockNegatifException, OrgUndeletableException {
        Panier panier = panierDao.find(id);
        List<LigneDeCommande> list = panier.getLigneDeCommandes();

        for (LigneDeCommande lc : list) {
            // list.remove( lc );
            // lc.setFicheCommande( null );
            ligneDeCommandeDao.delete(lc);

        }
        list.removeAll(list);
        panier.setLigneDeCommandes(list);
        System.out.println("SIZE : " + panier.getLigneDeCommandes().size());
        System.out.println("PRIX TOTAL : " + panier.getPrixTotal());
        return panierDao.update(panier);
    }

    // VALIDER PANIER ==> CREER NOUVELLE COMMANDE ---> OK

    public Commande validerPanier(Panier panier, Commande commande) throws StockNegatifException, OrgUndeletableException {

        List<LigneDeCommande> list = panier.getLigneDeCommandes();
        List<LigneDeCommande> list2 = new ArrayList<>();
        commande = new Commande();

        for (LigneDeCommande lc : list) {

            // DECREMENTATION DU STOCK
            Produit prod = lc.getProduit();
            int stock = prod.getStock();
            stock = stock - lc.getQuantite();
            prod.setStock(stock);
            produitDao.update(prod);

            list2.add(lc);
            System.out.println("LISTE 2 :" + list2);
        }

        // ATTRIBUT
        commande.setLigneDeCommandes(list2);
        commande.setPrixTotal(panier.getPrixTotal());
        commande.setIdClient(panier.getClient().getId());
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        commande.setDate(sdf.format(new Date()));

        return commandeDao.create(commande);

    }

    // METTRE A JOUr PANIER

    public Panier misAJourPanier(Panier panier) throws StockNegatifException {

        return  panierDao.update(panier);
    }

    public LigneDeCommande creerligne(LigneDeCommande lc, Panier panier) throws StockNegatifException {
        lc.setFicheCommande( panier );
        lc = ligneDeCommandeDao.create( lc );
        panier.getLigneDeCommandes().add( lc );
        panierDao.update( panier );
        return ligneDeCommandeDao.update( lc );
    }


// ----------------------------------------- FAVORIS -----------------------------------------------------------

    // AJOUTER UN PRODUIT AUX FAVORIS ---> OK

    public Favoris ajouterProduitAuxFavoris(Client client, Produit produit) throws StockNegatifException {

        Favoris fav = client.getFavoris();

        if (fav == null) {

            fav = new Favoris();
            fav.getProduits().add(produit);
            client.setFavoris(fav);
            fav = favorisDao.create(fav);
            clientDao.update(client);
        } else {

            fav.getProduits().add(produit);
            clientDao.update(client);
        }

        return fav;

    }

    // SUPPRIMER PRODUIT DES FAVORIS  ---> OK

    public Favoris supprimerProduitDesFavoris(Client client, Produit produit, Favoris fav) throws StockNegatifException {

        fav = client.getFavoris();

       fav.getProduits().remove(produit);

        return  favorisDao.update(fav);
    }

    // AFFICHER FAVORIS D'UN CLIENT ---> OK

    public List<Produit> afficherFavoris(String nom){
        Favoris fav = favorisDao.findByClient_Nom(nom);

        return fav.getProduits();
    }

// ------------------------------------------- COMMANDES --------------------------------------------

    // AFFICHER TOUTES LES COMMANDES

    public List<Commande> afficherToutesCommandes(){
        return commandeDao.findAll();
    }

    // AFFICHER LES COMMANDES D'UN CLIENT

    public List<Commande> afficherCommande(Client client) {

        Long id = client.getId();
        return commandeDao.findByIdClient(id);

    }


    public List<LigneDeCommande> afficherLigneCommande(Long id){
        return ligneDeCommandeDao.findByFicheCommande_Id( id );
    }




}




