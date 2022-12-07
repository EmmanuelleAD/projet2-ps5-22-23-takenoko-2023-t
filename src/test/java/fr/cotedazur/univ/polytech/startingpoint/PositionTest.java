package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testEquals() {
        Position p1=new Position(0,0);
        boolean res1=p1.equals(new Position(0,0));
        boolean expected1 = true;
        assertEquals(res1,expected1);

        Position p2=new Position(1,0);
        boolean res2=p2.equals(new Position(0,0));
        boolean expected2 = false;
        assertEquals(res2,expected2);

    }

/*    @Test
    void equalsParamX() {
        Position p1=new Position(1,0);
        boolean res1=p1.equals(new Position(0,0));
        boolean expected1 = true;
        assertEquals(res1,expected1);

        Position p2=new Position(0,0);
        boolean res2=p2.equals(new Position(0,0));
        boolean expected2 = false;
        assertEquals(res2,expected2);
    }*/
}