package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CerveauTest {

    @Test
    void decider() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        Cerveau cerveau = new Cerveau(joueur1);
        cerveau.decider(jeu);
        assertEquals(3, cerveau.decider(jeu).getNbreAction());

    }

    @Test
    void deciderReturnNull() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        Cerveau cerveau = new Cerveau(joueur1);
        cerveau.decider(jeu);
        assertEquals(null, cerveau.decider(jeu));

    }

    @Test
    void deciderJardinier() {
           Joueur joueur1 = new Joueur(1.85, "Wassim");
            Joueur joueur2 = new Joueur(1.6, "Brahim");
            Jeu jeu = new Jeu(joueur1, joueur2);
            jeu.initialisation();
            jeu.jouer();
            Cerveau cerveau = new Cerveau(joueur1);
            cerveau.deciderJardinier(jeu);
            assertEquals(3, cerveau.deciderJardinier(jeu).getNbreAction());

        }



}