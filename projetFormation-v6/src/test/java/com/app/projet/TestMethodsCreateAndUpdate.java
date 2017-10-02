package com.app.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.app.projet.entities.Adresse;
import com.app.projet.entities.Art;
import com.app.projet.entities.Client;
import com.app.projet.entities.DetailsFormation;
import com.app.projet.entities.Favoris;
import com.app.projet.entities.FormationArtistique;
import com.app.projet.entities.FormationInformatique;
import com.app.projet.entities.FormationLinguistique;
import com.app.projet.entities.FormationSportive;
import com.app.projet.entities.IdentifiantsConnexion;
import com.app.projet.entities.Langues;
import com.app.projet.entities.LigneDeCommande;
import com.app.projet.entities.OrganismeFormation;
import com.app.projet.entities.Panier;
import com.app.projet.entities.Sport;
import com.app.projet.entities.Techno;
import com.app.projet.exceptions.StockNegatifException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMethodsCreateAndUpdate  {

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
    public void testCreateAndUpdate() throws ParseException, StockNegatifException {

        // INSTANCIATION DES ENTITES

        IdentifiantsConnexion id1= new IdentifiantsConnexion("thierry", "tshthi");
        IdentifiantsConnexion id2= new IdentifiantsConnexion("dalia", "sordal");
        IdentifiantsConnexion id3= new IdentifiantsConnexion("juliette", "migjul");

        Adresse adresse1 = new Adresse("1 rue de laPaix", "Paris", 75009);
        Adresse adresse2 = new Adresse("2 rue Rougemont", "Paris", 75009);
        Adresse adresse3 = new Adresse("47 avenue de Rivoli3", "Paris", 75009);
        Adresse adresse4 = new Adresse("14 rue Montmartre", "Paris", 75009);
        Adresse adresse5 = new Adresse("5 rue Championnet", "Paris", 75009);
        Adresse adresse6 = new Adresse("6 rue Caulaincourt", "Paris", 75009);
        Adresse adresse7 = new Adresse("7 rue du 22 septembre", "Paris", 75009);
        Adresse adresse8 = new Adresse("8 avenue des champs elysees", "Paris", 75009);
        Adresse adresse9 = new Adresse("9 rue du Landy", "Paris", 75009);
        Adresse adresse10 = new Adresse("10 rue Riquet", "Paris", 75009);
        Adresse adresse11 = new Adresse("11 rue Ordener", "Paris", 75009);


        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

        Date hD1 = sdf.parse( "02/05/1980" );
        Date hD2 = sdf.parse( "02/05/1980" );



        Client cli1 = new Client("Tshibangu", "Thierry", "thi@gmail.com", hD1, adresse1, id1);
        Client cli2 = new Client("Sorial", "Dalia", "dal@gmail.com", hD2, adresse2, id2);

        Panier pan1 = cli1.getPanier();
        Panier pan2= cli2.getPanier();

        Favoris fav1= cli1.getFavoris();
        Favoris fav2= cli2.getFavoris();


        Administrateur admin = new Administrateur("Mignee", "Juliette", "jul@gmail.com", hD1, adresse3, id3);


        OrganismeFormation org1 = new OrganismeFormation("Ecole des Beaux Arts", adresse4);
        OrganismeFormation org2 = new OrganismeFormation("Ecole de Danse et Musique du 9 ème", adresse5);
        OrganismeFormation org3 = new OrganismeFormation("Cours de Langues Inc.", adresse6);
        OrganismeFormation org4 = new OrganismeFormation("MTN", adresse7);
        OrganismeFormation org5 = new OrganismeFormation("Association Sportive de Pantin", adresse8);
        OrganismeFormation org6 = new OrganismeFormation("Poudlard", adresse9);
        OrganismeFormation org7 = new OrganismeFormation("AJC", adresse10);
        OrganismeFormation org8 = new OrganismeFormation("FabLab", adresse11);



        DetailsFormation det1 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat.", org2);
        DetailsFormation det2 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org3);
        DetailsFormation det3 = new DetailsFormation(10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org7);
        DetailsFormation det4 = new DetailsFormation(400, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org5);
        DetailsFormation det5 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org2);
        DetailsFormation det6 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org4);
        DetailsFormation det7 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org8);
        DetailsFormation det8 = new DetailsFormation(10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org6);
        DetailsFormation det9 = new DetailsFormation(400, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org1);
        DetailsFormation det10 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org3);
        DetailsFormation det11 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org7);
        DetailsFormation det12 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org5);
        DetailsFormation det13 = new DetailsFormation(10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org1);
        DetailsFormation det14 = new DetailsFormation(400, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org4);
        DetailsFormation det15 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org8);
        DetailsFormation det16 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org6);
        DetailsFormation det17 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org2);
        DetailsFormation det18 = new DetailsFormation(10, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org3);
        DetailsFormation det19 = new DetailsFormation(400, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org7);
        DetailsFormation det20 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org5);
        DetailsFormation det21 = new DetailsFormation(40, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org1);
        DetailsFormation det22 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org4);
        DetailsFormation det23 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org8);
        DetailsFormation det24 = new DetailsFormation(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt id sapien quis bibendum. Nullam eleifend blandit risus in ornare. Donec vel massa id ligula tincidunt tristique eget sed tellus. Etiam lobortis lorem dui, nec maximus ante egestas feugiat. Sed auctor, nunc finibus efficitur sollicitudin, sapien mauris mattis nunc, eget vestibulum leo risus ut risus. Nullam velit est, placerat id dolor sit amet, iaculis fringilla sapien. Suspendisse potenti. Mauris ut turpis at purus tempor feugiat. ", org6);




        //		FormationArtistique prod1 = new FormationArtistique("Musique", 20, true, 250, det1, "url1", Art.MUSIQUE);
        //		FormationLinguistique prod2 = new FormationLinguistique("Anglais", 20, true, 250, det2, "url2",Langues.ANGLAIS);
        //		FormationInformatique prod3 = new FormationInformatique("Algorithme", 20, true, 250, det3, "url3", Techno.ALGO);
        //		FormationSportive prod4 = new FormationSportive("Football", 20, true, 250, det4 ,"url4", Sport.FOOT);
        //		FormationArtistique prod5 = new FormationArtistique("Tango", 20, true, 250, det5 , "url5",Art.DANSE);
        //		FormationLinguistique prod6 = new FormationLinguistique("Allemand", 20, true, 250, det6,"url6", Langues.ALLEMAND);
        //		FormationInformatique prod7 = new FormationInformatique("Java", 20, true, 250, det7,"url7",  Techno.JAVA);
        //		FormationSportive prod8 = new FormationSportive("Basket", 20, true, 250, det8 , "url8",Sport.BASKET);
        //		FormationArtistique prod9 = new FormationArtistique("Peinture", 20, true, 250, det9,"url9", Art.PEINTURE);
        //		FormationLinguistique prod10 = new FormationLinguistique("Français", 20, true, 250, det10,"url10", Langues.FRANCAIS);
        //		FormationInformatique prod11 = new FormationInformatique("Webservices", 20, true, 250, det11, "url1", Techno.WEBSERVICES);
        //		FormationSportive prod12 = new FormationSportive("Gymnastique", 20, true, 250, det12 , "url12",Sport.GYM);
        //		FormationArtistique prod13 = new FormationArtistique("Sculpture", 20, true, 250, det13,"url13", Art.SCULPTURE);
        //		FormationLinguistique prod14 = new FormationLinguistique("Espagnol", 20, true, 250, det14,"url14", Langues.ESPAGNOL);
        //		FormationInformatique prod15 = new FormationInformatique("Arduino", 20, true, 250, det15, "url15", Techno.ARDUINO);
        //		FormationSportive prod16 = new FormationSportive("VolleyBall", 20, true, 250, det16 , "url16",Sport.VOLLEYBALL);
        //		FormationArtistique prod17 = new FormationArtistique("Breakdance", 20, true, 250, det17,"url17", Art.BREAKDANCE);
        //		FormationLinguistique prod18 = new FormationLinguistique("Arabe", 20, true, 250, det18,"url18", Langues.ARABE);
        //		FormationInformatique prod19 = new FormationInformatique("Python", 20, true, 250, det19,"url19",  Techno.PYTHON);
        //		FormationSportive prod20 = new FormationSportive("Yoga", 20, true, 250, det20 , "url20",Sport.YOGA);
        //		FormationArtistique prod21 = new FormationArtistique("Dessin", 20, true, 250, det21, "url21",Art.DESSIN);
        //		FormationLinguistique prod22 = new FormationLinguistique("Finnois", 20, true, 250, det22, "url22",Langues.FINNOIS);
        //		FormationInformatique prod23 = new FormationInformatique("CSharp", 20, true, 250, det23, "url23", Techno.CSHARP);
        //		FormationSportive prod24 = new FormationSportive("Quidditch", 20, true, 250, det24 ,"url24", Sport.QUIDDITCH);


        FormationArtistique prod1 = new FormationArtistique("Cours de Musique Pour Debutants", 00, false, 250, det1, "..\\..\\/assets/Images/Musique.jpg", Art.MUSIQUE);
        FormationLinguistique prod2 = new FormationLinguistique("Cours d'Anglais Niveau 1", 20, true, 250, det2, "..\\..\\/assets/Images/Anglais.jpg",Langues.ANGLAIS);
        FormationInformatique prod3 = new FormationInformatique("Cours d'Algorithme Expert", 20, true, 250, det3, "..\\..\\/assets/Images/Algo.jpg", Techno.ALGO);
        FormationSportive prod4 = new FormationSportive("Session Football Junior", 20, true, 250, det4 ,"..\\..\\/assets/Images/Foot.jpg", Sport.FOOT);
        FormationArtistique prod5 = new FormationArtistique("Cours de Tango", 20, true, 250, det5 , "..\\..\\/assets/Images/Danse.jpg",Art.DANSE);
        FormationLinguistique prod6 = new FormationLinguistique("Cours d'Allemand niveau 2", 20, true, 250, det6,"..\\..\\/assets/Images/Allemand.jpg", Langues.ALLEMAND);
        FormationInformatique prod7 = new FormationInformatique("Cours Java Debutant", 20, true, 250, det7,"..\\..\\/assets/Images/Java.jpg",  Techno.JAVA);
        FormationSportive prod8 = new FormationSportive("Session Basket Tous Niveaux", 20, true, 250, det8 , "..\\..\\/assets/Images/Basket.jpg",Sport.BASKET);
        FormationArtistique prod9 = new FormationArtistique("Cours d'initition à la peinture", 20, true, 250, det9,"..\\..\\/assets/Images/Peinture.jpg", Art.PEINTURE);
        FormationLinguistique prod10 = new FormationLinguistique("Perfectionnement en Français", 20, true, 250, det10,"..\\..\\/assets/Images/Francais.jpg", Langues.FRANCAIS);
        FormationInformatique prod11 = new FormationInformatique("Developpez Vos Webservices", 20, true, 250, det11, "..\\..\\/assets/Images/Webservices.jpg", Techno.WEBSERVICES);
        FormationSportive prod12 = new FormationSportive("Cours de Gynastique pour garçons et filles", 20, true, 250, det12 , "..\\..\\/assets/Images/Gym.jpg",Sport.GYM);
        FormationArtistique prod13 = new FormationArtistique("Cours d'initiation à la sculpture", 20, true, 250, det13,"..\\..\\/assets/Images/Sculpture.jpg", Art.SCULPTURE);
        FormationLinguistique prod14 = new FormationLinguistique("Cours d'Espagnol debutant", 20, true, 250, det14,"..\\..\\/assets/Images/Espagnol.jpg", Langues.ESPAGNOL);
        FormationInformatique prod15 = new FormationInformatique("Construire votre ordinateur avec Arduina", 20, true, 250, det15, "..\\..\\/assets/Images/Arduino.jpg", Techno.ARDUINO);
        FormationSportive prod16 = new FormationSportive("Pratique de VolleyBall Niveau avance", 20, true, 250, det16 , "..\\..\\/assets/Images/Volleyball.jpg",Sport.VOLLEYBALL);
        FormationArtistique prod17 = new FormationArtistique("Cours de Breakdance", 20, true, 250, det17,"..\\..\\/assets/Images/Breakdance.jpg", Art.BREAKDANCE);
        FormationLinguistique prod18 = new FormationLinguistique("Cours d'arabe debutant", 20, true, 250, det18,"..\\..\\/assets/Images/Arabe.jpg", Langues.ARABE);
        FormationInformatique prod19 = new FormationInformatique("Developpez en Python", 20, true, 250, det19,"..\\..\\/assets/Images/Python.jpg",  Techno.PYTHON);
        FormationSportive prod20 = new FormationSportive("Cours de perfectionnement au Yoga Hatha", 20, true, 250, det20 , "..\\..\\/assets/Images/Yoga.jpg",Sport.YOGA);
        FormationArtistique prod21 = new FormationArtistique("Initiation au Dessin au fusain", 20, true, 250, det21, "..\\..\\/assets/Images/Dessin.jpg",Art.DESSIN);
        FormationLinguistique prod22 = new FormationLinguistique("Perfectionnement au Finnois", 20, true, 250, det22, "..\\..\\/assets/Images/Finnois.jpg",Langues.FINNOIS);
        FormationInformatique prod23 = new FormationInformatique("Developpez en C#", 20, true, 250, det23, "..\\..\\/assets/Images/Csharp.jpg", Techno.CSHARP);
        FormationSportive prod24 = new FormationSportive("Devenez aussi fort qu'Harry Potter en Quidditch", 20, true, 250, det24 ,"..\\..\\/assets/Images/Quidditch.jpg", Sport.QUIDDITCH);



        // CREATION

        organismeFormationDao.create(org1);
        organismeFormationDao.create(org2);
        organismeFormationDao.create(org3);
        organismeFormationDao.create(org4);
        organismeFormationDao.create(org5);
        organismeFormationDao.create(org6);
        organismeFormationDao.create(org7);
        organismeFormationDao.create(org8);



        produitDao.create( prod1 );
        produitDao.create( prod2 );
        produitDao.create( prod3 );
        produitDao.create( prod4 );
        produitDao.create( prod5 );
        produitDao.create( prod6 );
        produitDao.create( prod7 );
        produitDao.create( prod8 );
        produitDao.create( prod9 );
        produitDao.create( prod10 );
        produitDao.create( prod11 );
        produitDao.create( prod12 );
        produitDao.create( prod13 );
        produitDao.create( prod14 );
        produitDao.create( prod15 );
        produitDao.create( prod16 );
        produitDao.create( prod17);
        produitDao.create( prod18);
        produitDao.create( prod19);
        produitDao.create( prod20);
        produitDao.create( prod21);
        produitDao.create( prod22);
        produitDao.create( prod23);
        produitDao.create( prod24);



        clientDao.create(cli1);
        clientDao.create(cli2);
        adminDao.create(admin);




        // UPDATE

		/*prod1.setArtEnseigne(Art.MUSIQUE);
		prod2.setLanguesEnseigne(Langues.FRANCAIS);
		prod3.setTechnoEnseigne(Techno.JAVA);
		prod4.setSportEnseigne(Sport.FOOT);

		formationArtistiqueDao.update(prod1);
		formationLinguistiqueDao.update(prod2);
		formationInformatiqueDao.update(prod3);
		formationSportiveDao.update(prod4);

		prod1.getDetailsFormation().setDescriptif("desc12");
		prod2.getDetailsFormation().setDescriptif("desc22");
		prod3.getDetailsFormation().setDescriptif("desc32");
		prod4.getDetailsFormation().setDescriptif("desc42");

		produitDao.update(prod1);
		produitDao.update(prod2);
		produitDao.update(prod3);
		produitDao.update(prod4);


		cli1.setEmail("thi@yahoo.com");
		cli1.getIdentifiantsConnexion().setPassword("tshthi2");

		cli2.setNom("SORIAL");
		cli2.getIdentifiantsConnexion().setUserName("dalia2");

		clientDao.update(cli1);
		clientDao.update(cli2);



		pan1.getLigneDeCommandes().add(lc1);
		pan1.getLigneDeCommandes().add(lc2);

		panierDao.update(pan1);
*/




    }



}
