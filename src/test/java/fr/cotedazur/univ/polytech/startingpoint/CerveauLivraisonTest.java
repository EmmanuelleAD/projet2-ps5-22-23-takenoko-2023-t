package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CerveauLivraisonTest {

    Parcelle p11=new Parcelle(new Position(1,1));
    Joueur joueur=new Joueur(1.7,"Mohamed");
    Joueur botSaboteur =new Joueur(1.6,"Bot Saboteur");

    CerveauLivraison cerveauLivraison=new CerveauLivraison(botSaboteur);

    Jeu jeu=new Jeu(botSaboteur,joueur);
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
        assertEquals(Type.TypePiocher.getNomType(),act.getNomAction());

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
        assertEquals(Type.TypePiocher.getNomType(),act.getNomAction());
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
        assertEquals(Type.TypeParcelle.getNomType(),act.getNomAction());

    }


    @Test
    void testNbCartesSuperieurA5(){
        botSaboteur.setCartesObjectifs(new ArrayList<>());
        List<Bambou>joueurBambous=botSaboteur.getPlateau().getBambous();
        List<Bambou > listBambou=new ArrayList<>(joueurBambous);
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(2));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(1));
        botSaboteur.getCartesObjectifs().add(ObjectifPanda.objectifPandas.get(0));
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(botSaboteur.getCartesObjectifs().size(),7);
        assertEquals(Type.TypeParcelle.getNomType(),act.getNomAction());

    }

    @Test
    void testCasNormal(){
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(Type.TypePanda.getNomType(),act.getNomAction());
    }


    @Test
    void testCasDefaut(){
        jeu.getParcellesPlacees().add(p11);
        p11.setBambou(new Bambou(0));
        Action act=  cerveauLivraison.decider(jeu);
        assertEquals(Type.TypeParcelle.getNomType(),act.getNomAction());

    }



}