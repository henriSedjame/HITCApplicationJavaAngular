package com.app.projet;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.projet.dao.AdminDao;
import com.app.projet.dao.ClientDao;
import com.app.projet.dao.CommandeDao;
import com.app.projet.dao.DetailsFormationDao;
import com.app.projet.dao.FavorisDao;
import com.app.projet.dao.FicheCommandeDao;
import com.app.projet.dao.FormationArtistiqueDao;
import com.app.projet.dao.FormationInformatiqueDao;
import com.app.projet.dao.FormationLinguistiqueDao;
import com.app.projet.dao.FormationSportiveDao;
import com.app.projet.dao.IdentifiantsConnexionDao;
import com.app.projet.dao.LigneDeCommandeDao;
import com.app.projet.dao.OrganismeFormationDao;
import com.app.projet.dao.PanierDao;
import com.app.projet.dao.ProduitDao;
import com.app.projet.dao.UtilisateurDao;
import com.app.projet.entities.Administrateur;
import com.app.projet.entities.Client;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import com.app.projet.exceptions.OrgUndeletableException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMethodsDelete {
	
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
	LigneDeCommandeDao ligneDeCommandeDao ;
	@Autowired
    UtilisateurDao utilisateurDao;
	@Autowired
    OrganismeFormationDao organismeFormationDao;
	@Autowired
    DetailsFormationDao detailsFormationDao;
	
	
	
	
	
	@Test
	public void testDelete()  {
	/*Client client =clientDao.find(34L);
	try {
		clientDao.delete(client);
	} catch (OrgUndeletableException e1) {
		System.out.println(e1.getMessage());
	}
	*/
	
	/*Administrateur adnim = adminDao.find(42L);
	try {
		adminDao.delete(adnim);
	} catch (OrgUndeletableException e2) {
		System.out.println(e2.getMessage());
	}
*/
	Produit produit = produitDao.find(32L);
	try {
		produitDao.delete(produit);
	} catch (OrgUndeletableException e3) {
		System.out.println(e3.getMessage());
	}
	
	
	OrganismeFormation organismeFormation = organismeFormationDao.find(25L);
	try {
		organismeFormationDao.delete(organismeFormation);
	} catch (OrgUndeletableException e) {
		System.out.println(e.getMessage());
	}
	
	
		

	}

}
