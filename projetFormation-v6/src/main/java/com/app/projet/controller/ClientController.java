package com.app.projet.controller;

import com.app.projet.dao.ClientDao;
import com.app.projet.dao.OrganismeFormationDao;
import com.app.projet.dao.PanierDao;
import com.app.projet.dao.ProduitDao;
import com.app.projet.entities.*;
import com.app.projet.exceptions.*;
import com.app.projet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    ClientDao clientDao;
    @Autowired
    ProduitDao produitDao;
    @Autowired
    PanierDao panierDao;
    @Autowired
    OrganismeFormationDao organismeFormationDao;


    // ---------------------------------- ADMIN -----------------------------------------------------------

    @GetMapping(value = "/clients")
    public List<Client> findAll(){
        return clientDao.findAll();
    }

    // ---------------------------------  CONNNEXION ------------------------------------------------------


    @GetMapping("/connexion/{login}_{password}")
    public ResponseEntity<Client> seConnecter(@PathVariable("login") String login, @PathVariable("password") String password, ArrayList<LigneDeCommande> panierVirtuel) throws ClientNotFoundException{
        Client client = clientService.seConnecter(login, password, panierVirtuel);
        return new ResponseEntity<Client>(client, HttpStatus.ACCEPTED);
    }

    @GetMapping("/deconnexion")
    public void seDeconnecter(HttpServletRequest req, ArrayList<LigneDeCommande> panierVirtuel, Client clientConnecte) throws StockNegatifException{
        clientService.seDeconnecter(req, panierVirtuel, clientConnecte);
    }

    @PostMapping(value = "/postClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> sInscrire(@RequestBody Client client) throws ClientAlreadyExisting {
        System.out.println(client.getAdresse().getCodePostal());
        return new ResponseEntity<Client>(clientService.sInscrire(client), HttpStatus.CREATED);
    }


    //------------------------------- GESTION PROFIL ------------------------------------------------------

    @PutMapping(value = "/updateId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> modifClient(@RequestBody  Client client) throws StockNegatifException {

        return new ResponseEntity<Client>(clientService.modifClient(client), HttpStatus.OK);
    }

    // ---------------------------------  PRODUITS ----------------------------------------------------------

    @GetMapping("/produits")
    public ResponseEntity <List<Produit>> rechercherTousLesProduits(){
        return new ResponseEntity<List<Produit>>(clientService.rechercherTousLesProduits(), HttpStatus.OK);
    }

    @GetMapping("/produits/categorie_{cat}")
    public ResponseEntity <List<Produit>> rechercherParCategorie(@PathVariable("cat") String cat){
        return new ResponseEntity<List<Produit>>(clientService.rechercherParCategorie(cat), HttpStatus.OK);
    }

    @GetMapping("/produits/prix_{prix1}-{prix2}")
    public ResponseEntity <List<Produit>> rechercherParFourchetteDePrix(@PathVariable("prix1") double prix1, @PathVariable("prix2")double prix2){
        return new ResponseEntity<List<Produit>>(clientService.rechercherParFourchetteDePrix(prix1, prix2), HttpStatus.OK);
    }

    @GetMapping("/produits/designation_{des}")
    public Produit rechercherParDesignation(@PathVariable("des") String des){
        return clientService.rechercherParDesignation(des);
    }

    @GetMapping("/produits/organisme_{id_org}")
    public ResponseEntity <List<Produit>> rechercherParOrganisme(@PathVariable("id_org") Long id){
        OrganismeFormation org = organismeFormationDao.find(id);
        return new ResponseEntity<List<Produit>>(clientService.rechercherParOrganisme(org), HttpStatus.OK);
    }

    @GetMapping("/produits/organisme_Nom_{nomOrg}")
    public ResponseEntity <List<Produit>> rechercherParOrganisme(@PathVariable("nomOrg") String nomOrg){
        return new ResponseEntity<List<Produit>>(clientService.rechercherParOrganisme(nomOrg), HttpStatus.OK);
    }

    @GetMapping("/produits/duree_{duree}")
    public ResponseEntity <List<Produit>> rechercherParDuree(@PathVariable("duree") int duree) throws
            EmptyResponseException {
        return new ResponseEntity<List<Produit>>(clientService.rechercherParDuree(duree), HttpStatus.OK);
    }

    @GetMapping("/organisme/produit_{des}")
    public ResponseEntity<OrganismeFormation> rechercherOrg(@PathVariable("des") String des){
        return new ResponseEntity<OrganismeFormation>( clientService.rechercherOrganisme( des ), HttpStatus.OK );
    }

    @PostMapping("/ligneCommande/create_{id}")
    public ResponseEntity<LigneDeCommande> creerLigne(@PathVariable Long id, @RequestBody LigneDeCommande lc, Panier panier) throws StockNegatifException{
        panier = panierDao.find( id );
        return  new ResponseEntity<LigneDeCommande>( clientService.creerligne( lc, panier ) , HttpStatus.OK );
    }

    @GetMapping("/produits/ligneCommande/{id}")
    public ResponseEntity<Produit> rechercherProduitParLigneCommande(@PathVariable Long id) {
        return new ResponseEntity<Produit>( clientService.rechercherProduitParLigneCommande( id ), HttpStatus.OK );
    }

    // ---------------------------------  PANIER -------------------------------------------------------------


    @GetMapping("/panier/{nom}")
    public ResponseEntity<Panier> afficherPanier(@PathVariable("nom") String nom){

        return new ResponseEntity<Panier>(clientService.afficherPanier(nom), HttpStatus.OK);
    }

    @PutMapping(value="/panier/{id_panier}+{des}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Panier> ajouterProduitAuPanier( @PathVariable("id_panier") Long id,@PathVariable("des") String des, @RequestBody LigneDeCommande ligneDeCommande)throws StockNegatifException {

        return new ResponseEntity<Panier>(clientService.ajouterProduitAuPanier( id, des, ligneDeCommande), HttpStatus.OK);
    }

    @PutMapping(value = "/panier/vider_{id}", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Panier> viderPanier(@PathVariable("id") Long id) throws StockNegatifException,
            OrgUndeletableException {

        return new ResponseEntity<Panier>( clientService.viderPanier(id), HttpStatus.OK );
    }

    @PostMapping(value = "/panier/validate_{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Commande> validerPanier(@PathVariable("id") Long id, Panier panier, @RequestBody Commande commande) throws StockNegatifException, OrgUndeletableException {
        panier = panierDao.find(id);
        return new ResponseEntity<Commande>(clientService.validerPanier(panier, commande), HttpStatus.OK);
    }

    @PutMapping("/panier/maj")
    public ResponseEntity<Panier> misAJourPanier(@RequestBody Panier panier ) throws StockNegatifException {
        return new ResponseEntity<Panier>(clientService.misAJourPanier(panier), HttpStatus.OK);
    }




    // ---------------------------------  FAVORIS -------------------------------------------------

    @PostMapping(value = "/favoris/add_{id_client}_{des}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Favoris> ajouterProduitAuxFavoris(@PathVariable("id_client") Long id, @PathVariable("des") String des, @RequestBody Client client) throws StockNegatifException {
        System.out.println("ETAPE 1");
        client = clientDao.find(id);
        Produit produit = produitDao.findByDesignation(des);

        System.out.println("ETAPE 2");
        return new ResponseEntity<Favoris>(clientService.ajouterProduitAuxFavoris(client, produit), HttpStatus.OK);
    }

    @PutMapping(value = "/favoris/delete_{id_client}_{des}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Favoris> supprimerProduitDesFavoris(@PathVariable("id_client") Long id, @PathVariable("des") String des, @RequestBody Favoris fav )throws StockNegatifException{
        Client client = clientDao.find(id);
        Produit produit = produitDao.findByDesignation(des);
        return new ResponseEntity<Favoris>(clientService.supprimerProduitDesFavoris(client, produit, fav), HttpStatus.OK);
    }

    @GetMapping("/favoris/{nom}")
    public ResponseEntity<List<Produit>> afficherFavoris(@PathVariable String nom){
        return new ResponseEntity<List<Produit>>(clientService.afficherFavoris(nom), HttpStatus.OK);
    }

    // ---------------------------------  COMMANDES -------------------------------------------------

    @GetMapping("/commandes")
    public ResponseEntity<List<Commande>> afficherToutesCommande(){
        return new ResponseEntity<List<Commande>>(clientService.afficherToutesCommandes(), HttpStatus.OK);
    }

    @GetMapping("/commandes/{id}")
    public ResponseEntity<List<Commande>> afficherCommande(@PathVariable("id") Long id, Client client){

        client = clientDao.find(id);

        return new ResponseEntity<List<Commande>>(clientService.afficherCommande(client), HttpStatus.OK);

    }

    @GetMapping("/ligneCommandes/{id}")
    public ResponseEntity<List<LigneDeCommande>> afficherLigneCommande(@PathVariable("id") Long id) {
        return new ResponseEntity<List<LigneDeCommande>>( clientService.afficherLigneCommande( id ), HttpStatus.OK );
    }











}
