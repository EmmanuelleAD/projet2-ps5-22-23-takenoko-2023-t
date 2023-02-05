package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
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
}
