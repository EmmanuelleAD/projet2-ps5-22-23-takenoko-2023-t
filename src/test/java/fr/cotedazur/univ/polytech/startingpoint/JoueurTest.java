package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    private final Joueur wassim=new Joueur(1.7,"Wassim");
    private final Joueur brahim=new Joueur(1.8,"Brahim");

    private final Joueur mohamed=new Joueur(1.78,"Mohamed");

    private final Joueur emmanuelle=new Joueur(1.6,"Emmanuelle");


    @Test
    void testTailleComparator() {
        List<Joueur>joueurs=new ArrayList<>();
        joueurs.add(wassim);
        joueurs.add(brahim);
        joueurs.add(emmanuelle);
        joueurs.add(mohamed);
        Collections.sort(joueurs,Joueur.tailleComparator);
        assertEquals(joueurs.get(0),emmanuelle);
        assertEquals(joueurs.get(1),wassim);
        assertEquals(joueurs.get(2),mohamed);
        assertEquals(joueurs.get(3),brahim);
        Collections.sort(joueurs,Joueur.tailleComparator.reversed());
        assertEquals(joueurs.get(3),emmanuelle);
        assertEquals(joueurs.get(2),wassim);
        assertEquals(joueurs.get(1),mohamed);
        assertEquals(joueurs.get(0),brahim);


    }
    @Test
    void testScoreComparator(){
        wassim.addScore(2);
        brahim.addScore(4);
        emmanuelle.addScore(6);
        mohamed.addScore(8);
        List<Joueur>joueurs=new ArrayList<>();
        joueurs.add(wassim);
        joueurs.add(brahim);
        joueurs.add(emmanuelle);
        joueurs.add(mohamed);
        Collections.sort(joueurs,Joueur.scoreComparator);
        assertEquals(joueurs.get(0),wassim);
        assertEquals(joueurs.get(1),brahim);
        assertEquals(joueurs.get(2),emmanuelle);
        assertEquals(joueurs.get(3),mohamed);
        Collections.sort(joueurs,Joueur.scoreComparator.reversed());
        assertEquals(joueurs.get(3),wassim);
        assertEquals(joueurs.get(2),brahim);
        assertEquals(joueurs.get(1),emmanuelle);
        assertEquals(joueurs.get(0),mohamed);



    }



    @Test
    void addScore() {
        wassim.addScore(10);
        assertEquals(10, wassim.getScore());

        brahim.addScore(5);
        assertEquals(5, brahim.getScore());
    }

    @Test
    void getScore() {
        wassim.addScore(10);
        assertEquals(10, wassim.getScore());

        brahim.addScore(5);
        assertEquals(5, brahim.getScore());
    }

    @Test
    void getNom() {
        assertEquals("Wassim",wassim.getNom());
        assertEquals("Brahim",brahim.getNom());
        assertEquals("Mohamed",mohamed.getNom());
        assertEquals("Emmanuelle",emmanuelle.getNom());
    }

    @Test
    void setNom() {
        wassim.setNom("David");
        assertEquals("David",wassim.getNom());

        brahim.setNom("Jean");
        assertEquals("Jean",brahim.getNom());
    }

    @Test
    void getCartesObjectifs() {

    }

    @Test
    void setCartesObjectifs() {

    }

    @Test
    void getTaille() {
        assertEquals(1.7,wassim.getTaille());
        assertEquals(1.8,brahim.getTaille());
    }

    @Test
    void setTaille() {

        wassim.setTaille(1.8);
        assertEquals(1.8,wassim.getTaille());

        brahim.setTaille(1.7);
        assertEquals(1.7, brahim.getTaille());

    }

    @Test
    void jouer() {

    }

    @Test
    void effectuerActionParcelle() {
    }

    @Test
    void getPartieGagnees() {
        brahim.setPartieGagnees(2);
        assertEquals(2,brahim.getPartieGagnees());

        wassim.setPartieGagnees(3);
        assertEquals(3,wassim.getPartieGagnees());


    }

    @Test
    void setPartieGagnees() {

        brahim.setPartieGagnees(2);
        assertEquals(2,brahim.getPartieGagnees());

        wassim.setPartieGagnees(3);
        assertEquals(3,wassim.getPartieGagnees());
    }


    @Test
    void ajoutPartieGagnees() {
        wassim.ajoutPartieGagnees(10);
        assertEquals(10, wassim.getPartieGagnees());

        brahim.ajoutPartieGagnees(5);
        assertEquals(5, brahim.getPartieGagnees());
    }

    @Test
    void getPlateau() {
        Plateau plateau = new Plateau();
        wassim.setPlateau(plateau);
        assertEquals(plateau,wassim.getPlateau());
    }

    @Test
    void getScoreMoyen() {
        brahim.setScoreMoyen(2);
        assertEquals(2,brahim.getScoreMoyen());

        wassim.setScoreMoyen(3);
        assertEquals(3,wassim.getScoreMoyen());
    }

    @Test
    void setScoreMoyen() {
        brahim.setScoreMoyen(10);
        assertEquals(10,brahim.getScoreMoyen());

        wassim.setScoreMoyen(15);
        assertEquals(15, wassim.getScoreMoyen());
    }

    @Test
    void ajoutScoreMoyen() {
        brahim.setScoreMoyen(10);
        brahim.ajoutScoreMoyen(10);
        assertEquals(20,brahim.getScoreMoyen());

        wassim.setScoreMoyen(15);
        wassim.ajoutScoreMoyen(15);
        assertEquals(30,wassim.getScoreMoyen());
    }


    @Test
    void getPartieNulles() {
        brahim.ajoutPartieNulles(10);
        assertEquals(10,brahim.getPartieNulles());

        wassim.ajoutPartieNulles(15);
        assertEquals(15,wassim.getPartieNulles());
    }

    @Test
    void setPartieNulles() {
        brahim.setPartieNulles(20);
        assertEquals(20,brahim.getPartieNulles());

        wassim.setPartieNulles(5);
        assertEquals(5,wassim.getPartieNulles());
    }

    @Test
    void ajoutPartieNulles() {
        brahim.setPartieNulles(20);
        brahim.ajoutPartieNulles(20);
        assertEquals(40,brahim.getPartieNulles());

        wassim.setPartieNulles(5);
        wassim.ajoutPartieNulles(5);
        assertEquals(10,wassim.getPartieNulles());
    }


    @Test
    void testAddScore() {
        brahim.addScore(10);
        assertEquals(10,brahim.getScore());

        wassim.addScore(15);
        assertEquals(15,wassim.getScore());
    }

    @Test
    void setScore() {
        brahim.setScore(15);
        assertEquals(15,brahim.getScore());

        wassim.setScore(50);
        assertEquals(50,wassim.getScore());
    }


    @Test
    void testGetScore() {
        brahim.setScore(10);
        assertEquals(10,brahim.getScore());

        wassim.setScore(15);
        assertEquals(15,wassim.getScore());
    }


    @Test
    void testGetCerveau() {
        CerveauJardinier cerveau =new CerveauJardinier(wassim);
        wassim.setCerveau(cerveau);
        assertEquals(cerveau,wassim.getCerveau());

    }

    @Test
    void testSetCerveau() {
    }






    @Test
    void testGetCartesObjectifs() {
    }

    @Test
    void testSetCartesObjectifs() {
    }



    @Test
    void testEffectuerActionParcelle() {
    }

    @Test
    void setPlateau() {
    }
}