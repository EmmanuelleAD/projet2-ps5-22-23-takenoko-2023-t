package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CerveauLivraisonTest {

    Parcelle p11=new Parcelle(new Position(1,1));
    Parcelle p12=new Parcelle(new Position(1,2));

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
        assertEquals(Type.TypePanda.getNomType(),act.getNomAction());

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
        assertEquals(Type.TypeParcelle.getNomType(),act.getNomAction());

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
        assertEquals(action.getNomAction(),Type.TypeParcelle.getNomType());



    }







}