package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Position pos;
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
        for (int i=0;i<6;i++){
            assertEquals(tabTest1[i],tab1[i]);
        }
    }

    @Test
    void getX() {
        Position p1=new Position(0,0);
        int res1=p1.getX();
        int expected1 = 0;
        assertEquals(res1,expected1);

        Position p2=new Position(1,0);
        int res2=p2.getX();
        int expected2 = 1;
        assertEquals(res2,expected2);
    }

    @Test
    void setX() {
        Position p1=new Position(0,0);
        p1.setX(1);
        int res1=p1.getX();
        int expected1 = 1;
        assertEquals(res1,expected1);

        Position p2=new Position(1,0);
        p2.setX(0);
        int res2=p2.getX();
        int expected2 = 0;
        assertEquals(res2,expected2);
    }

    @Test
    void getY() {
        Position p1=new Position(0,0);
        int res1=p1.getY();
        int expected1 = 0;
        assertEquals(res1,expected1);

        Position p2=new Position(1,1);
        int res2=p2.getY();
        int expected2 = 1;
        assertEquals(res2,expected2);
    }

    @Test
    void setY() {
        Position p1=new Position(0,0);
        p1.setY(1);
        int res1=p1.getY();
        int expected1 = 1;
        assertEquals(res1,expected1);

        Position p2=new Position(1,1);
        p2.setY(0);
        int res2=p2.getY();
        int expected2 = 0;
        assertEquals(res2,expected2);
    }



    @Test
    void testToString() {
        Position p1=new Position(0,0);
        String res1=p1.toString();
        String expected1 = "(0,0)";
        assertEquals(res1,expected1);

        Position p2=new Position(1,1);
        String res2=p2.toString();
        String expected2 = "(1,1)";
        assertEquals(res2,expected2);
    }

    @Test
    void positionEnLigneDroite() {
        Position p1=new Position(0,0);
        boolean res1=p1.positionEnLigneDroite(new Position(0,0),new Position(1,0),new Position(2,0));
        boolean expected1 = true;
        assertEquals(res1,expected1);

        Position p2=new Position(1,1);
        boolean res2=p2.positionEnLigneDroite(new Position(0,1),new Position(1,6),new Position(0,3));
        boolean expected2 = false;
        assertEquals(res2,expected2);
    }

    @Test
    void estAdjacente() {
        Position p1=new Position(0,0);
        boolean res1=p1.estAdjacente(new Position(0,1));
        boolean expected1 = true;
        assertEquals(res1,expected1);

        Position p2=new Position(1,1);
        boolean res2=p2.estAdjacente(new Position(0,5));
        boolean expected2 = false;
        assertEquals(res2,expected2);
    }
    @Test
    void estDroitCasNormalTest(){
        pos=new Position(1,2);
        assertTrue(Position.isStraightMovement(Parcelle.etang.getPosition(), pos));
         pos=new Position(3,6);
        assertTrue(Position.isStraightMovement(Parcelle.etang.getPosition(), pos));
        pos=new Position(2,4);
        assertTrue(Position.isStraightMovement(Parcelle.etang.getPosition(), pos));
        Position pos1=new Position(-1,0);
        Position pos2=new Position(-1,1);
        assertTrue(Position.isStraightMovement(pos1, pos2));

    }

}