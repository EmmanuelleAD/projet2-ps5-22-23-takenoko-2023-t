package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CerveauJardinierTest {
    Parcelle p11 = new Parcelle(new Position(1,1));

    Parcelle p10 = new Parcelle(new Position(1,0));
    Parcelle p20 = new Parcelle(new Position(2,0));
    Parcelle p21 = new Parcelle(new Position(2,1));
    Joueur joueur=new Joueur(1.7,"Mohamed");
    Joueur joueuse=new Joueur(1.6,"Emmanuelle");
    CerveauJardinier cerveauJardinier=new CerveauJardinier(joueuse);
    Jeu jeu=new Jeu(joueuse,joueur);
    @BeforeEach
    void setUp(){
        joueuse.setCerveau(new CerveauJardinier(joueuse));
        jeu.initialisation();
    }

    @Test
    void testCasNormal(){
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauJardinier.decider(jeu);
        assertEquals(Type.TYPE_JARDINIER.getNomType(),act.getNomAction());
    }

    @Test
    void testCasDefaut(){
        joueuse.setCartesObjectifs(new ArrayList<>());
        joueuse.getCartesObjectifs().add(ObjectifJardinier.objectifsJardinier.get(0));
        jeu.getParcellesPlacees().add(p11);
        p11.setBambou(new Bambou(4));
        Action act=  cerveauJardinier.decider(jeu);
        assertEquals(Type.TYPE_PARCELLE.getNomType(),act.getNomAction());
    }

    @Test
    void testSansCartes(){
        joueuse.setCartesObjectifs(new ArrayList<>());
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauJardinier.decider(jeu);
        assertEquals(Type.TYPE_PIOCHER.getNomType(),act.getNomAction());


    }


    @Test
    void tailleBambooParcelle() {
        Joueur joueur = new Joueur(1.5,"brahim");
        CerveauJardinier cerveauJardinier = new CerveauJardinier(joueur);
        Bambou bambou = new Bambou(3);
        Parcelle parcelle = new Parcelle(new Position(1,1));
        parcelle.setBambou(bambou);

        int expectedTaille = 3;
        int actualTaille = cerveauJardinier.tailleBambooParcelle(parcelle);

        assertEquals(expectedTaille, actualTaille);
    }

    @Test
    void testerCasB43(){
        joueuse.setCartesObjectifs(new ArrayList<>());
        joueuse.getCartesObjectifs().add(ObjectifJardinier.objectifsJardinier.get(1));
        p20.setBambou(new Bambou(2));
        p10.setBambou(new Bambou(3));
        p11.setBambou(new Bambou(3));
        p21.setBambou(new Bambou(3));
        jeu.getParcellesPlacees().addAll(Arrays.asList(p10,p11,p10,p20));
        ActionJardinier act = (ActionJardinier) cerveauJardinier.decider(jeu);
        assertEquals(act.getParcelle(),p20);
    }
    @Test
    void testerCasB14(){
        joueuse.setCartesObjectifs(new ArrayList<>());
        joueuse.getCartesObjectifs().add(ObjectifJardinier.objectifsJardinier.get(0));
        p10.setBambou(new Bambou(3));
        jeu.getParcellesPlacees().add(p10);
        ActionJardinier act = (ActionJardinier) cerveauJardinier.decider(jeu);
        assertEquals(act.getParcelle(),p10);
    }



}