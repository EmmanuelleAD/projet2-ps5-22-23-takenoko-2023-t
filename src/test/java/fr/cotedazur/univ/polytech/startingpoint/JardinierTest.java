package fr.cotedazur.univ.polytech.startingpoint;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JardinierTest {
    Jardinier jardinier=new Jardinier();
    List<Parcelle> parcelles = new ArrayList<>();
    Parcelle pdeTaille4 = new Parcelle(new Position(2, 2));

    @BeforeEach
    void setUp() {
        parcelles.add(pdeTaille4);
        pdeTaille4.setBambou(new Bambou(4));

    }


    @Test
    void testDeplacementQuandTaille4() {
        jardinier.move(pdeTaille4,parcelles);
        assertTrue(pdeTaille4.getBambou().isPresent());
        assertEquals(4,pdeTaille4.getTaille());

    }
    @Test
    void testPasDeBambousSurEtang(){
        parcelles.add(Parcelle.etang);
        jardinier.move(Parcelle.etang,parcelles);
        assertFalse(Parcelle.etang.bambou.isPresent());

    }
}
