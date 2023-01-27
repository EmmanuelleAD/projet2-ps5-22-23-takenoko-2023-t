package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testJoueur() {
        Joueur joueur = new Joueur(1.85, "Wassim");
        assertEquals(1.85, joueur.getTaille(), 0.001);
        assertEquals("Wassim", joueur.getNom());
    }

    @Test
    public void testJeu() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        assertNotNull(jeu);
    }

    @Test
    public void testInitialisation() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        assertNotNull(jeu.getJoueur1());
        assertNotNull(jeu.getJoueur2());

    }


    @Test
    void main() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

    }
}