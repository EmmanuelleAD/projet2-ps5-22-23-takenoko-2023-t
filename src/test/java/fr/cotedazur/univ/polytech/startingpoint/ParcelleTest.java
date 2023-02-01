package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class ParcelleTest {



    @Test
    void testIsAdjacent() {
        Parcelle p1=new Parcelle(new Position(0,0));
        Parcelle p2=new Parcelle(new Position(1,0));
        boolean res1=true;
        assertEquals(p1.isAdjacent(p2),res1);

        Parcelle p3=new Parcelle(new Position(0,0));
        Parcelle p4=new Parcelle(new Position(0,2));
        boolean res2=false;
        assertEquals(p3.isAdjacent(p4),res2);
    }



    @Test
    void testParcelleAdjacentes() {
        Position p1= new Position(0,0);
        Parcelle par1 = new Parcelle(p1);

        Parcelle[] tabTest1=par1.parcelleAdjacentes();

        Parcelle[] tabPar1={new Parcelle(new Position(-1,0)),
                new Parcelle(new Position(1,0)),
                new Parcelle(new Position(-1,-1)),
                new Parcelle(new Position(-1,1)),
                new Parcelle(new Position(0,-1)),
                new Parcelle(new Position(0,1))};


        for (int i=0;i<6;i++){
            assertEquals(tabTest1[i],tabPar1[i]);
        }
    }





}