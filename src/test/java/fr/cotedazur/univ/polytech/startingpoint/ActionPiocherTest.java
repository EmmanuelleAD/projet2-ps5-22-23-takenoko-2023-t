package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActionPiocherTest {

    @Test
    public void testActionPiocher() {
        ObjectifParcelle obj = new ObjectifParcelle("ALI3", 2, false, "3 Parcelles alignées");
        ActionPiocher ap = new ActionPiocher(obj);
        assertEquals(ap.getObjectif(), obj);
        assertEquals(ap.getDescription(), " a pioché la carte Objectif : 3 Parcelles alignées");
    }

    @Test
    public void testActionPiocherTraiter() {
        ObjectifJardinier obj = new ObjectifJardinier("B43",8,false,"4 Bambous de taille 3",3,4);
        ActionPiocher ap = new ActionPiocher(obj);
        Joueur j = new Joueur(1.80,"j1");
        Jeu jeu = new Jeu(Arrays.asList(j));
        jeu.getObjectifsJardinier().add(obj);
        assertTrue(ap.traiter(j, jeu));
        assertTrue(j.getCartesObjectifs().contains(obj));
        assertFalse(jeu.getObjectifsParcelles().contains(obj));
    }

    @Test
    public void testActionPiocherEquals() {
        Objectif obj1 = new ObjectifPanda("P2J",4,false,"2 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1)));
        Objectif obj2 = new ObjectifPanda("P3V",3,false,"3 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1),new Bambou(1)));
        ActionPiocher ap1 = new ActionPiocher(obj1);
        ActionPiocher ap2 = new ActionPiocher(obj1);
        ActionPiocher ap3 = new ActionPiocher(obj2);
        assertTrue(ap1.equals(ap2));
        assertFalse(ap1.equals(ap3));
    }

    @Test
    public void testActionPiocherHashCode() {
        Objectif obj1 = new ObjectifParcelle("GRP3", 4, false, "3 Parcelles groupées");
        Objectif obj2 = new ObjectifParcelle("GRP4", 4, false, "4 Parcelles groupées");
        ActionPiocher ap1 = new ActionPiocher(obj1);
        ActionPiocher ap2 = new ActionPiocher(obj1);
        ActionPiocher ap3 = new ActionPiocher(obj2);
        assertEquals(ap1.hashCode(), ap2.hashCode());
        assertNotEquals(ap1.hashCode(), ap3.hashCode());
    }

}