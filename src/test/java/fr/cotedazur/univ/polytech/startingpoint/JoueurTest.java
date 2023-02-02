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
}