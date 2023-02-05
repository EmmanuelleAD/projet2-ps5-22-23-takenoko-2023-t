package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

public class ObjectifPandaTest {
    ObjectifPanda objectifPanda;
    List<Bambou> bambouList=new ArrayList<>();
    @BeforeEach
    void setUp(){


    }
    @Test
    void creerObjectif(){
        objectifPanda=new ObjectifPanda("MANGB",2,false,"",bambouList);
        assertEquals(new ArrayList<Bambou>(),bambouList);
        assertEquals(2,objectifPanda.getPoints());
        assertEquals("MANGB",objectifPanda.getNom());
    }
}
