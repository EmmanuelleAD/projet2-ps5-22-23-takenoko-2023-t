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


    @Test
    void testPositionsAdjacentes() {
        //Position y Paire
        Position p1= new Position(0,0);
        Position[] tabTest1=p1.positionsAdjacentes();
        Position[] tab1={new Position(-1,0),new Position(1,0),new Position(0,-1),new Position(  0,1),new Position(1,-1),new Position(1,1)};
        for (int i=0;i<6;i++){
            assertEquals(tabTest1[i],tab1[i]);
        }


        //Position y imPaire

        Position p2= new Position(0,1);
        Position[] tabTest2=p2.positionsAdjacentes();
        Position[] tab2={new Position(-1,0),new Position(1,0),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,1)};
        for (int i=0;i<6;i++){
            assertEquals(tabTest1[i],tab1[i]);
        }
    }
}