package fr.cotedazur.univ.polytech.startingpoint;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

 class JardinierTest {
    Jardinier jardinier=new Jardinier();
    List<Parcelle> parcelles = new ArrayList<>();
    Parcelle pdeTaille4 = new Parcelle(new Position(2, 2));
    Parcelle parcellesSansBambou=new Parcelle(new Position(1,1));

    @BeforeEach
    void setUp() {
        pdeTaille4.setBambou(new Bambou(4));
        parcelles.add(pdeTaille4);
        parcelles.add(parcellesSansBambou);
        parcellesSansBambou.setBambou(new Bambou(0));


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
    @Test
    void  casNormal(){
        jardinier.move(parcellesSansBambou,parcelles);
        assertTrue(parcellesSansBambou.bambou.isPresent());
        assertEquals(1,parcellesSansBambou.getBambou().get().getTaille());
        jardinier.move(parcellesSansBambou,parcelles);
        assertEquals(2,parcellesSansBambou.getBambou().get().getTaille());



    }
    @Test
    void pousseSurLesParcellesAdjacentes(){

    }
}
