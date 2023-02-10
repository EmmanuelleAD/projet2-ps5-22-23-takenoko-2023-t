package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {
    Plateau plateau;
    Joueur joueur;
    Panda panda;
    Bambou bambou=new Bambou(1);
    @BeforeEach
    void setUp(){
        plateau=new Plateau();


    }
    @Test
    void creerPlateau(){
        assertEquals(new ArrayList<Bambou>(),plateau.getBambous());

    }
    @Test
    void ajouterBambou(){
        plateau.ajouterBambou(bambou);
        assertTrue(plateau.getBambous().contains(bambou));

    }
}
