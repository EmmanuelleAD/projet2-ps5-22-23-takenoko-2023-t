package fr.cotedazur.univ.polytech.startingpoint;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;


public class ActionPandaTest {

    @Test
    public void testGetNomAction() {
        Parcelle parcelle = new Parcelle(new Position(1, 1));
        ActionPanda actionPanda = new ActionPanda(parcelle);
        assertEquals("PANDA", actionPanda.getNomAction());
    }

    @Test
    public void testGetDescription() {
        Parcelle parcelle = new Parcelle(new Position(1, 1));
        ActionPanda actionPanda = new ActionPanda(parcelle);
        assertEquals(" a éffectué une action PANDA en (1,1). Le bambou a une taille actuelle de 1", actionPanda.getDescription());
    }

    @Test
    public void testTraiter() throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1,"wassim");
        Joueur joueur2 = new Joueur(1,"brahim");
        Jeu jeu = new Jeu(joueur1,joueur2);
        Parcelle parcelle = new Parcelle(new Position(1, 1));
        ActionPanda actionPanda = new ActionPanda(parcelle);
        assertTrue(actionPanda.traiter(joueur1, jeu));
    }



    @Test
    public void testEquals() {
        Parcelle parcelle = new Parcelle(new Position(1, 1));
        ActionPanda actionPanda1 = new ActionPanda(parcelle);
        ActionPanda actionPanda2 = new ActionPanda(parcelle);
        assertTrue(actionPanda1.equals(actionPanda2));
    }

    @Test
    public void testHashCode() {
        Parcelle parcelle = new Parcelle(new Position(1, 1));
        ActionPanda actionPanda1 = new ActionPanda(parcelle);
        ActionPanda actionPanda2 = new ActionPanda(parcelle);
        assertEquals(actionPanda1.hashCode(), actionPanda2.hashCode());
    }


    @Test
    public void testEqualsActionPanda() {
        Parcelle parcelle1 = new Parcelle(new Position(1,1));
        ActionPanda actionPanda1 = new ActionPanda(parcelle1);
        Parcelle parcelle2 = new Parcelle(new Position(1,1));
        ActionPanda actionPanda2 = new ActionPanda(parcelle2);
        Parcelle parcelle3 = new Parcelle(new Position(2,2));
        ActionPanda actionPanda3 = new ActionPanda(parcelle3);
        assertTrue(actionPanda1.equals(actionPanda2));
        assertFalse(actionPanda1.equals(actionPanda3));
        assertFalse(actionPanda1.equals(null));
        assertFalse(actionPanda1.equals("actionPanda1"));
    }

    @Test
    public void testHashCodeActionPanda() {
        Parcelle parcelle1 = new Parcelle(new Position(1,1));
        ActionPanda actionPanda1 = new ActionPanda(parcelle1);
        Parcelle parcelle2 = new Parcelle(new Position(1,1));
        ActionPanda actionPanda2 = new ActionPanda(parcelle2);
        Parcelle parcelle3 = new Parcelle(new Position(2,2));
        ActionPanda actionPanda3 = new ActionPanda(parcelle3);
        assertEquals(actionPanda1.hashCode(), actionPanda2.hashCode());
        assertNotEquals(actionPanda1.hashCode(), actionPanda3.hashCode());
    }


}
