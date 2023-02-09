package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CerveauLivraisonTest {

    Parcelle p11=new Parcelle(new Position(1,1));
    Parcelle p12=new Parcelle(new Position(1,2));

    Joueur joueur=new Joueur(1.7,"Mohamed");
    Joueur joueur1 = new Joueur(1.6, "Emmanuelle");
    Joueur botSaboteur =new Joueur(1.6,"Bot Saboteur");

    CerveauLivraison cerveauLivraison=new CerveauLivraison(botSaboteur);

    Jeu jeu=new Jeu(botSaboteur,joueur);


    CerveauLivraisonTest() throws NoSuchAlgorithmException {
    }

    @BeforeEach
    void setUp(){
        botSaboteur.setCerveau(new CerveauLivraison(botSaboteur));
        jeu.initialisation();
    }



    @Test
    void testSansCartes(){
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(Type.TYPE_PIOCHER.getNomType(),act.getNomAction());

    }



    @Test
    void testNbCartesInferieureA5(){
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        List<Bambou>joueurBambous=botSaboteur.getPlateau().getBambous();
        List<Bambou > listBambou=new ArrayList<>(joueurBambous);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(botSaboteur.getCartesObjectifs().size(),1);
        assertEquals(Type.TYPE_PIOCHER.getNomType(),act.getNomAction());
    }

    @Test
    void testNbCartesEgalA5(){
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        List<Bambou>joueurBambous=botSaboteur.getPlateau().getBambous();
        List<Bambou > listBambou=new ArrayList<>(joueurBambous);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(botSaboteur.getCartesObjectifs().size(),5);
        assertEquals(Type.TYPE_PANDA.getNomType(),act.getNomAction());

    }


    @Test
    void testNbCartesSuperieurA5SansParc(){
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        List<Bambou>joueurBambous=botSaboteur.getPlateau().getBambous();
        List<Bambou > listBambou=new ArrayList<>(joueurBambous);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(botSaboteur.getCartesObjectifs().size(),5);
        assertEquals(Type.TYPE_PANDA.getNomType(),act.getNomAction());

    }
    @Test
    void test5Cartes1Mouvement(){ //5 cartes avec un mouvement en ligne possible
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        jeu.getParcellesPlacees().add(p11);
        ActionPanda act=(ActionPanda)cerveauLivraison.decider(jeu);
        assertEquals(1,cerveauLivraison.getI());
        assertEquals(p11,act.getParcelle());


    }
    @Test
    void testSeFocaliserSur2(){ //5 cartes avec un mouvement en ligne possible
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        jeu.getParcellesPlacees().add(p11);
        ActionPanda act=(ActionPanda)cerveauLivraison.decider(jeu);
        assertEquals(1,cerveauLivraison.getI());
        assertEquals(p11,act.getParcelle());
        p11.setBambou(new Bambou(0));
        jeu.getParcellesPlacees().add(p12);
        act=(ActionPanda)cerveauLivraison.decider(jeu);
        assertEquals(0,cerveauLivraison.getI());
        assertEquals(p12,act.getParcelle());
        p12.setBambou(new Bambou(0));
       Action action=cerveauLivraison.decider(jeu);
        assertEquals(1,cerveauLivraison.getI());
        assertEquals(action.getNomAction(),Type.TYPE_PANDA.getNomType());
    }
    @Test
    void detecterSabotagePandaVrai(){
        Jeu jeu=new Jeu(botSaboteur,joueur);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1)); //mettre 5 cartes pour que ça soit pas actionPiocher
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1)); //valider les objectifs du saboteur pour qu'ils ne cherchent pas à les réaliser
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1));
        joueur.setCartesObjectifs(Arrays.asList(ObjectifPanda.objectifPandas.get(2)));
        joueur.getPlateau().ajouterBambou(new Bambou(1)); //créer la situatuion un seul manquant pour l'adversaire
        joueur.getPlateau().ajouterBambou(new Bambou(1));
        jeu.getParcellesPlacees().add(p11);      //ajouter la parcelle ou il peut potentiellement se déplacer
        ActionPanda act=(ActionPanda) cerveauLivraison.decider(jeu);
       List<Parcelle> parcelles= Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),new Bambou(1));
       parcelles=jeu.getPanda().deplacementsPossibles(parcelles);
       assertEquals(parcelles.get(0),act.getParcelle());
    }
    @Test
    void detecterSabotagePandaFaux(){
        Jeu jeu=new Jeu(botSaboteur,joueur);
        jeu.initialisation();
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1)); //mettre 5 cartes pour que ça soit pas actionPiocher
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        System.out.println(botSaboteur.getCartesObjectifs());
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1)); //valider les objectifs du saboteur pour qu'ils ne cherchent pas à les réaliser
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1));
        joueur.setCartesObjectifs(Arrays.asList(ObjectifPanda.objectifPandas.get(2)));
        joueur.getPlateau().ajouterBambou(new Bambou(1)); //créer la situatuion un seul manquant pour l'adversaire
        joueur.getPlateau().ajouterBambou(new Bambou(1));
        jeu.getParcellesPlacees().add(p11);//ajouter la parcelle ou il peut potentiellement se déplacer
        ActionPanda actionPanda=new ActionPanda(p11);
        Action act= cerveauLivraison.decider(jeu,actionPanda); //on ne peut pas éffectuer 2 actions de suite
        List<Position> listPlacement = jeu.getPlacementsPossibles();
        Action action=new ActionParcelle(new Parcelle( listPlacement.get(0)));
        assertEquals(action,act);
    }
    @Test
    void detecterSabotagePandaCasPiocher(){
        Jeu jeu=new Jeu(botSaboteur,joueur);
        jeu.initialisation();
        botSaboteur.setCartesObjectifs(Arrays.asList(ObjectifPanda.objectifPandas.get(1)));
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1)); //valider les objectifs du saboteur pour qu'ils ne cherchent pas à les réaliser
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1));
        joueur.setCartesObjectifs(Arrays.asList(ObjectifPanda.objectifPandas.get(2)));
        joueur.getPlateau().ajouterBambou(new Bambou(1)); //créer la situatuion un seul manquant pour l'adversaire
        joueur.getPlateau().ajouterBambou(new Bambou(1));
        jeu.getParcellesPlacees().add(p11);      //ajouter la parcelle ou il peut potentiellement se déplacer
        ActionPanda act=(ActionPanda) cerveauLivraison.decider(jeu,new ActionPiocher(ObjectifPanda.objectifPandas.get(2)));//passer une action piocher pour le forcer à faire une autre action
        List<Parcelle> parcelles= Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),new Bambou(1));
        parcelles=jeu.getPanda().deplacementsPossibles(parcelles);
        assertEquals(parcelles.get(0),act.getParcelle());
    }
    @Test
    void detecterSabotageJardinierVrai(){
        Jeu jeu=new Jeu(botSaboteur,joueur);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1)); //mettre 5 cartes pour que ça soit pas actionPiocher
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1)); //valider les objectifs du saboteur pour qu'ils ne cherchent pas à les réaliser
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1));
        joueur.setCartesObjectifs(Arrays.asList(ObjectifJardinier.objectifsJardinier.get(0)));
        p11.setBambou(new Bambou(3));
        jeu.getParcellesPlacees().add(p11);
        ActionPanda act=(ActionPanda) cerveauLivraison.decider(jeu);
        assertEquals(act.getParcelle(),p11);
        p11.setBambou(new Bambou(1));
        p12.setBambou(new Bambou(3));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,0)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(2,1)));
        jeu.getParcellesPlacees().add(p12);
        ActionPanda act2 = (ActionPanda) cerveauLivraison.detecterActionJardinier(jeu, new ActionJardinier(p11));
        assertEquals(p12, act2.getParcelle());
    }

    @Test
    void detecterSabotageJardinierScore(){
        Jeu jeu2 = new Jeu(Arrays.asList(botSaboteur,joueur,joueur1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1)); //mettre 5 cartes pour que ça soit pas actionPiocher
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1)); //valider les objectifs du saboteur pour qu'ils ne cherchent pas à les réaliser
        botSaboteur.getPlateau().ajouterBambou(new Bambou(1));
        joueur.setCartesObjectifs(Arrays.asList(ObjectifJardinier.objectifsJardinier.get(1)));
        p11.setBambou(new Bambou(3));
        jeu2.getParcellesPlacees().add(p11);
        ActionPanda act=(ActionPanda) cerveauLivraison.decider(jeu2);
        assertEquals(act.getParcelle(),p11);
        joueur1.setScore(2);
        joueur.setScore(0);
        p11.setBambou(new Bambou(1));
        p12.setBambou(new Bambou(3));
        jeu2.getParcellesPlacees().add(new Parcelle(new Position(1,0)));
        jeu2.getParcellesPlacees().add(new Parcelle(new Position(2,1)));
        jeu2.getParcellesPlacees().add(p12);
        ActionPanda act2 = (ActionPanda) cerveauLivraison.detecterActionJardinier(jeu2, new ActionJardinier(p11));
        assertNull(act2);
        List<Joueur> joueursSansLivraison = new ArrayList<>(jeu2.getJoueurs());
        Collections.sort(joueursSansLivraison, Joueur.scoreComparator.reversed());
        assertEquals(joueursSansLivraison.get(0),joueur1);
    }








}