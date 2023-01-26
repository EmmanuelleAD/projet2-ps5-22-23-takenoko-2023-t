package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    private Joueur wassim=new Joueur(1.7,"Wassim");
    private Joueur brahim=new Joueur(1.8,"Brahim");

    private Joueur mohamed=new Joueur(1.78,"Mohamed");

    private Joueur emmanuelle=new Joueur(1.6,"Emmanuelle");


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
    void getCerveau() {

    }


    @Test
    void setCerveau() {

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
        assertEquals(wassim.getTaille(),1.7);
        assertEquals(brahim.getTaille(),1.8);
    }

    @Test
    void setTaille() {

        wassim.setTaille(1.8);
        assertEquals(wassim.getTaille(),1.8);

        brahim.setTaille(1.7);
        assertEquals(brahim.getTaille(),1.7);

    }

    @Test
    void jouer() {

    }

    @Test
    void effectuerActionParcelle() {
    }
}