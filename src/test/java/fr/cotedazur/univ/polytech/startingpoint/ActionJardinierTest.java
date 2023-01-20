package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionJardinierTest {

    @Test
    void getDescription() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        Position position = new Position(1, 1);
        ActionJardinier actionJardinier = new ActionJardinier(new Parcelle(position));
        String comment = " a éffectué une action Jardinier en " + position.toString();
        assertEquals(comment , actionJardinier.getDescription());
    }
}