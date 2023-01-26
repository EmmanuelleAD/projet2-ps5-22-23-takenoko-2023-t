package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        Main main = new Main();
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        assertEquals(joueur1.getNom(), "Wassim");
        assertEquals(joueur2.getNom(), "Brahim");
        assertEquals(joueur1.getTaille(), 1.85, 0.01);
        assertEquals(joueur2.getTaille(), 1.6, 0.01);
    }


}