package com.app.projet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.app.projet.entities.FormationArtistique;
import com.app.projet.entities.IdentifiantsConnexion;
import com.app.projet.entities.LigneDeCommande;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Produit;
import org.junit.Assert;
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
import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.Favoris;
import com.app.projet.entities.FicheCommande;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMethodsFind {
	
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
	public void testFind() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		
		

	       /*Client client = clientDao.find(265L);
	       Administrateur admin = adminDao.find(269L);
	       Produit prod = produitDao.find(253L);
	       OrganismeFormation org = organismeFormationDao.find(251L);
	       LigneDeCommande ldc = ligneDeCommandeDao.find(273L);
	       IdentifiantsConnexion id = identifiantsConnexionDao.find(266L);
	       FicheCommande fc = panierDao.find(268L);
	       Favoris fav = favorisDao.find(267L);
	       DetailsFormation det = detailsFormationDao.find(254L);
	       
	       Assert.assertTrue(client.getNom().equals("SORIAL"));
	       Assert.assertTrue(client.getAdresse().getCodePostale() == 12345);
	       Assert.assertTrue(client.getPrenom().equals("Dalia"));
	       Assert.assertTrue(client.getDateNaissance().equals(sdf.parse( "02/05/1980")));
	       Assert.assertTrue(client.getAdresse().getRue().equals("rue2"));
	       Assert.assertTrue(client.getAdresse().getVille().equals("ville"));
	       Assert.assertTrue(client.getEmail().equals("dal@gmail.com"));
	       Assert.assertTrue(client.getFavoris().getId() == 267L);
	       Assert.assertTrue(client.getPanier().getId() == 268L);
	       
	       Assert.assertTrue(admin.getNom().equals("Mignee"));
	       Assert.assertTrue(admin.getAdresse().getCodePostale() == 12345);
	       Assert.assertTrue(admin.getPrenom().equals("Juliette"));
	       Assert.assertTrue(admin.getDateNaissance().equals(sdf.parse( "02/05/1980")));
	       Assert.assertTrue(admin.getAdresse().getRue().equals("rue3"));
	       Assert.assertTrue(admin.getAdresse().getVille().equals("ville"));
	       Assert.assertTrue(admin.getEmail().equals("jul@gmail.com"));
	       
	       Assert.assertTrue(prod.getDesignation().equals("art"));
	       Assert.assertThat(prod.getCategorie().valueOf("ARTISTIQUE"), is(notNullValue()));
	       
	       Assert.assertTrue(prod.isDisponibilite() == true);
	       Assert.assertTrue(prod.getPrixUnitaire() == 250d);
	       Assert.assertTrue(prod.getStock() == 20);
	       Assert.assertTrue(prod.getDetailsFormation().getId() == 254L);
	       
	       Assert.assertTrue(org.getNom().equals("AJC"));
	       Assert.assertTrue(org.getAdresse().getCodePostale() == 12345);
	       Assert.assertTrue(org.getAdresse().getRue().equals("rue4"));
	       Assert.assertTrue(org.getAdresse().getVille().equals("ville"));

	       Assert.assertTrue(ldc.getQuantite() == 1);
	       Assert.assertTrue(ldc.getFicheCommande().getId() == 268L);
	       Assert.assertTrue(ldc.getProduit().getId() == 257L);
	 
	       Assert.assertTrue(id.getPassword().equals("sordal"));
	       Assert.assertTrue(id.getUserName().equals("dalia2"));
	       	       
	       Assert.assertTrue(fc.getPrixTotal() == 0);
	       
	       Assert.assertTrue(det.getDescriptif().equals("44406"));
	       Assert.assertTrue(det.getDuree() == 400);
	       Assert.assertTrue(det.getOrganismeFormation().getId() == 251L);
	       
	       List<Client> listC = clientDao.findAll();
	       
	       Assert.assertTrue(listC.size() == 1);
*/

//	       List<Produit> list = produitDao.findAll();
//
//		for (Produit p : list
//			 ) {
//			System.out.println(p.getDesignation());
//			System.out.println(p.getCategorie());
//		}

		Favoris fav = favorisDao.find(40L);

		for (Produit p: fav.getProduits()) {
			System.out.println(p.getCategorie());
		}


		
	}


}
