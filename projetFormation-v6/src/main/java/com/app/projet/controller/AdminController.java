package com.app.projet.controller;

import com.app.projet.entities.Administrateur;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import com.app.projet.exceptions.ClientNotFoundException;
import com.app.projet.exceptions.OrgUndeletableException;
import com.app.projet.exceptions.StockNegatifException;
import com.app.projet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {


    @Autowired
    AdminService adminService;

    @GetMapping("/admin/connexion_{login}_{mdp}")
    public ResponseEntity<Administrateur> connecterAdmin(@PathVariable("login") String login, @PathVariable("mdp") String mdp) throws ClientNotFoundException {

       return new ResponseEntity<Administrateur>( adminService.connecterAdmin( login, mdp ), HttpStatus.OK );

    }

    @GetMapping("/admin/produits")
    public ResponseEntity<List<Produit>> findAll() {
        return new ResponseEntity<List<Produit>>( adminService.findAll(), HttpStatus.OK );
    }

    @GetMapping("/admin/produits_{cat}")
    public ResponseEntity<List<Produit>> findByCategorie (@PathVariable String cat) {
        return new ResponseEntity<List<Produit>>( adminService.findByCategorie( cat ), HttpStatus.OK );
    }

    @PutMapping("/admin/produits/update")
    public ResponseEntity<Produit> updateProduit (Produit prod) throws StockNegatifException {
        return new ResponseEntity<Produit>( adminService.updateProduit( prod ), HttpStatus.OK );
    }

    @DeleteMapping("/admin/produits/del_{id}")
    public boolean supprimerProduit (@PathVariable Long id) throws OrgUndeletableException {
        return adminService.supprimerProduit( id );
    }

    @GetMapping("/admin/org")
    public ResponseEntity<List<OrganismeFormation>> findOrgAll() {
        return new ResponseEntity<List<OrganismeFormation>>( adminService.findOrgAll(), HttpStatus.OK );
    }

    @PutMapping("/admin/org/update")
    public ResponseEntity<OrganismeFormation> modifierOrg(OrganismeFormation org) throws StockNegatifException{
        return new ResponseEntity<OrganismeFormation>( adminService.modifierOrg( org ), HttpStatus.OK );
    }

    @DeleteMapping("/admin/org/del_{id}")
    public boolean supprimerOrg(@PathVariable Long id) throws OrgUndeletableException {
        return adminService.supprimerOrg( id );
    }

    @GetMapping("/admin/produit/{id}")
    public ResponseEntity<Produit> findProduit(@PathVariable Long id) {
        return new ResponseEntity<Produit>( adminService.findProduit(id), HttpStatus.OK );
    }
}
