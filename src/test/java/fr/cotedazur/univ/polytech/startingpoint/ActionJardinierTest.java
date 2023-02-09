package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ActionJardinierTest {




    @Test
    void getDescription() throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        Position position = new Position(1, 1);
        ActionJardinier actionJardinier = new ActionJardinier(new Parcelle(position));
        String comment = " a effectue une action JARDINIER en " + position.toString()+". Le bambou a une taille actuelle de 1";
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
    void testHashCode() throws NoSuchAlgorithmException {
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


    @Test
    public void testGetParcelle() {
        Parcelle parcelle = new Parcelle(new Position(0,0));
        ActionJardinier actionJardinier = new ActionJardinier(parcelle);
        assertEquals(parcelle, actionJardinier.getParcelle());
    }



    private ActionJardinier actionJardinier;
    private Parcelle parcelle;


    @BeforeEach
    public void setUp() {
        parcelle = new Parcelle(new Position(1, 2));
        actionJardinier = new ActionJardinier(parcelle);
    }

    @Test
    public void testEqualsWithSameObject() {
        assertEquals(actionJardinier, actionJardinier);
    }

    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals(actionJardinier, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals(actionJardinier, parcelle);
    }

    @Test
    public void testEqualsWithDifferentParcelle() {
        Parcelle parcelle2 = new Parcelle(new Position(2, 3));
        ActionJardinier actionJardinier2 = new ActionJardinier(parcelle2);
        assertNotEquals(actionJardinier, actionJardinier2);
    }

    @Test
    public void testEqualsWithEqualParcelle() {
        Parcelle parcelle2 = new Parcelle(new Position(1, 2));
        ActionJardinier actionJardinier2 = new ActionJardinier(parcelle2);
        assertEquals(actionJardinier, actionJardinier2);
    }

    @Test
    public void testHashCodeWithEqualObjects() {
        Parcelle parcelle2 = new Parcelle(new Position(1, 2));
        ActionJardinier actionJardinier2 = new ActionJardinier(parcelle2);
        assertEquals(actionJardinier.hashCode(), actionJardinier2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentObjects() {
        Parcelle parcelle2 = new Parcelle(new Position(2, 3));
        ActionJardinier actionJardinier2 = new ActionJardinier(parcelle2);
        assertNotEquals(actionJardinier.hashCode(), actionJardinier2.hashCode());
    }
}


