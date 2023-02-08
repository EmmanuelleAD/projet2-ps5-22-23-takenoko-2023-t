package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectifPandaTest {
    Joueur joueur=new Joueur(1.8,"tam");
    Plateau plateau=joueur.getPlateau();
    ObjectifPanda objectifPanda;

    List<Bambou> bambouList=new ArrayList<>();
    @BeforeEach
    void setUp(){
        objectifPanda=ObjectifPanda.objectifPandas.get(0);



    }
    @Test
    void creerObjectif(){
        objectifPanda=new ObjectifPanda("MANGB",2,false,"",bambouList);
        assertEquals(new ArrayList<Bambou>(),bambouList);
        assertEquals(2,objectifPanda.getPoints());
        assertEquals("MANGB",objectifPanda.getNom());
    }
    @Test
    void  estValiderCasNormal(){
        plateau.ajouterBambou(new Bambou(1));
        assertTrue(objectifPanda.estValide(new ArrayList<>(),joueur));

    }
    @Test
    void  estPasValiderCasNormal(){
        assertFalse(objectifPanda.estValide(new ArrayList<>(),joueur));

    }
    @Test
    void testEstValide2Bambous(){
        objectifPanda=ObjectifPanda.objectifPandas.get(1);
        plateau.ajouterBambou(new Bambou(1));
        plateau.ajouterBambou(new Bambou(1));
        assertTrue(objectifPanda.estValide(new ArrayList<>(),joueur));

    }
    @Test
    void testEstPasValide2Bambous(){
        objectifPanda=ObjectifPanda.objectifPandas.get(1);
        plateau.ajouterBambou(new Bambou(1));
        assertFalse(objectifPanda.estValide(new ArrayList<>(),joueur));

    }
    @Test
    void testEstValide3Bambous(){
        objectifPanda=ObjectifPanda.objectifPandas.get(2);
        plateau.ajouterBambou(new Bambou(1));
        plateau.ajouterBambou(new Bambou(1));
        plateau.ajouterBambou(new Bambou(1));
        assertTrue(objectifPanda.estValide(new ArrayList<>(),joueur));

    }
    @Test
    void testEstPasValide3Bambous(){
        objectifPanda=ObjectifPanda.objectifPandas.get(2);
        plateau.ajouterBambou(new Bambou(1));
        plateau.ajouterBambou(new Bambou(1));
        assertFalse(objectifPanda.estValide(new ArrayList<>(),joueur));

    }


    @Test
    public void testGetBambous() {
        ObjectifPanda objectifPanda = new ObjectifPanda("MANGB", 2, false, " une section mangée ", Arrays.asList(new Bambou(1)));
        List<Bambou> expected = Arrays.asList(new Bambou(1));
        List<Bambou> actual = objectifPanda.getBambous();
        assertEquals(expected, actual);
    }


    @Test
    public void testGetType() {
        ObjectifPanda objectifPanda = new ObjectifPanda("MANGB", 2, false, " une section mangée ", Arrays.asList(new Bambou(1)));
        String expected = "PANDA";
        String actual = objectifPanda.getType();
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsObjectifPanda() {
        List<Bambou> bambous1 = Arrays.asList(new Bambou(1));
        List<Bambou> bambous2 = Arrays.asList(new Bambou(1), new Bambou(1));
        ObjectifPanda objPanda1 = new ObjectifPanda("MANGB", 2, false, "une section mangée", bambous1);
        ObjectifPanda objPanda2 = new ObjectifPanda("MANGB", 2, false, "une section mangée", bambous1);
        ObjectifPanda objPanda3 = new ObjectifPanda("P2J", 4, false, "2 sections mangées", bambous2);
        assertTrue(objPanda1.equals(objPanda2));
        assertFalse(objPanda1.equals(objPanda3));
    }

    @Test
    public void testHashCodeObjectifPanda() {
        List<Bambou> bambous1 = Arrays.asList(new Bambou(1));
        List<Bambou> bambous2 = Arrays.asList(new Bambou(1), new Bambou(1));
        ObjectifPanda objPanda1 = new ObjectifPanda("MANGB", 2, false, "une section mangée", bambous1);
        ObjectifPanda objPanda2 = new ObjectifPanda("MANGB", 2, false, "une section mangée", bambous1);
        ObjectifPanda objPanda3 = new ObjectifPanda("P2J", 4, false, "2 sections mangées", bambous2);
        assertEquals(objPanda1.hashCode(), objPanda2.hashCode());
        assertNotEquals(objPanda1.hashCode(), objPanda3.hashCode());
    }

}
