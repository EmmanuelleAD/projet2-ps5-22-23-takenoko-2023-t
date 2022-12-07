package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class ParcelleTest {
/*
    @Test
    void isAdjacent() {
        Parcelle p1=new Parcelle(new Position(0,0));
        Parcelle p2=new Parcelle(new Position(10,0));
        boolean res1=true;
        assertEquals(p1.isAdjacent(p2),res1);

        Parcelle p3=new Parcelle(new Position(0,0));
        Parcelle p4=new Parcelle(new Position(15,0));
        boolean res2=false;
        assertEquals(p3.isAdjacent(p4),res2);
    }*/


    @Test
    void isAdjacent() {
        Parcelle p1=new Parcelle(new Position(0,0));
        Parcelle p2=new Parcelle(new Position(1,0));
        boolean res1=true;
        assertEquals(p1.isAdjacent(p2),res1);

        Parcelle p3=new Parcelle(new Position(0,0));
        Parcelle p4=new Parcelle(new Position(0,2));
        boolean res2=false;
        assertEquals(p3.isAdjacent(p4),res2);
    }

}