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

        Position position = new Position(1, 1);
        ActionJardinier actionJardinier = new ActionJardinier(new Parcelle(position));
        String comment = " a éffectué une action Jardinier en " + position.toString()+". Le bambou a une taille actuelle de 1";
        assertEquals(comment , actionJardinier.getDescription());
    }

    @Test
    void testEquals() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        Position position = new Position(1, 1);
        ActionJardinier actionJardinier = new ActionJardinier(new Parcelle(position));
        ActionJardinier actionJardinier1 = new ActionJardinier(new Parcelle(position));
        assertEquals(actionJardinier, actionJardinier1);


    }

    @Test
    void testHashCode() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        Position position = new Position(1, 1);
        ActionJardinier actionJardinier = new ActionJardinier(new Parcelle(position));
        ActionJardinier actionJardinier1 = new ActionJardinier(new Parcelle(position));
        assertEquals(actionJardinier.hashCode(), actionJardinier1.hashCode());
    }


    @Test
    public void testEqualsReflexive() {
        ActionJardinier action = new ActionJardinier(new Parcelle(new Position(0,0)));
        assertTrue(action.equals(action));
    }

    @Test
    public void testEqualsSymmetric() {
        ActionJardinier action1 = new ActionJardinier(new Parcelle(new Position(0,0)));
        ActionJardinier action2 = new ActionJardinier(new Parcelle(new Position(0,0)));
        assertTrue(action1.equals(action2) && action2.equals(action1));
    }

    @Test
    public void testEqualsTransitive() {
        ActionJardinier action1 = new ActionJardinier(new Parcelle(new Position(0,0)));
        ActionJardinier action2 = new ActionJardinier(new Parcelle(new Position(0,0)));
        ActionJardinier action3 = new ActionJardinier(new Parcelle(new Position(0,0)));
        assertTrue(action1.equals(action2) && action2.equals(action3) && action1.equals(action3));
    }



}