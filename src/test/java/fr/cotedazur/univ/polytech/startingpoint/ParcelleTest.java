package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParcelleTest {
    private Parcelle etang=new Parcelle(new Position(0,0));

    @Test
    void testEquals() {
        Parcelle p1=new Parcelle(new Position(0,0));
        Parcelle p2=new Parcelle(new Position(0,0));
        boolean res1=true;
        assertEquals(p1.equals(p2),res1);

        Parcelle p3=new Parcelle(new Position(1,0));
        boolean res2=false;
        assertEquals(p1.equals(p3),res2);

    }

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

        Parcelle p5=new Parcelle(new Position(1,0));
        Parcelle p6=new Parcelle(new Position(0,1));
        boolean res3=true;
        assertEquals(p3.isAdjacent(p4),res2);

        Parcelle p7=new Parcelle(new Position(1,0));
        Parcelle p8=new Parcelle(new Position(-1,4));
        boolean res4=false;
        assertEquals(p3.isAdjacent(p4),res2);
    }



    @Test
    void testParcelleAdjacentes() {
        //Test y pair
        Position p1= new Position(0,0);
        Parcelle par1 = new Parcelle(p1);
        Parcelle[] tabTest1=par1.parcelleAdjacentes();

        Parcelle[] tabPar1={new Parcelle(new Position(-1,0)),
                new Parcelle(new Position(1,0)),
                new Parcelle(new Position(0,-1)),
                new Parcelle(new Position(0,1)),
                new Parcelle(new Position(1,-1)),
                new Parcelle(new Position(1,1))};

        for (int i=0;i<6;i++){
            assertEquals(tabTest1[i],tabPar1[i]);
        }

        Position p2= new Position(3,2);
        Parcelle par2= new Parcelle(p2);
        Parcelle[] tabTest2=par2.parcelleAdjacentes();

        Parcelle[] tabPar2={new Parcelle(new Position(2,2)),
                new Parcelle(new Position(4,2)),
                new Parcelle(new Position(3,1)),
                new Parcelle(new Position(3,3)),
                new Parcelle(new Position(4,1)),
                new Parcelle(new Position(4,3))};

        for (int i=0;i<6;i++){
            assertEquals(tabTest2[i],tabPar2[i]);
        }


        //Test y impair
        Position p3= new Position(0,1);
        Parcelle par3= new Parcelle(p3);
        Parcelle[] tabTest3=par3.parcelleAdjacentes();

        Parcelle[] tabPar3={new Parcelle(new Position(-1,1)),
                new Parcelle(new Position(1,1)),
                new Parcelle(new Position(0,0)),
                new Parcelle(new Position(0,2)),
                new Parcelle(new Position(-1,0)),
                new Parcelle(new Position(-1,2))};

        for (int i=0;i<6;i++){
            assertEquals(tabTest3[i],tabPar3[i]);
        }


        Position p4= new Position(3,5);
        Parcelle par4= new Parcelle(p4);
        Parcelle[] tabTest4=par4.parcelleAdjacentes();

        Parcelle[] tabPar4={new Parcelle(new Position(2,5)),
                new Parcelle(new Position(4,5)),
                new Parcelle(new Position(3,4)),
                new Parcelle(new Position(3,6)),
                new Parcelle(new Position(2,4)),
                new Parcelle(new Position(2,6))};

        for (int i=0;i<6;i++){
            assertEquals(tabTest4[i],tabPar4[i]);
        }




    }
    @Nested
    class testPlacements{
        @Test
        void testPlacementEtang(){
            List<Parcelle >parcellesPlacees=new ArrayList<>();
            parcellesPlacees.add(etang);
            List<Position> positions=Parcelle.positionsPossible(parcellesPlacees,new ArrayList<Position>());
            Position[] adjacEtangs=etang.getPosition().positionsAdjacentes();
            for (int i=0;i<6;i++){
                assertEquals(positions.get(i),adjacEtangs[i]);
            }

        }

        @Test
        void testPlacementAdjacentA2(){
            int count;
            List<Parcelle >parcellesPlacees=new ArrayList<>();
            parcellesPlacees.add(etang);
            parcellesPlacees.addAll(List.of(etang.parcelleAdjacentes()));
            List<Position> positions=Parcelle.positionsPossible(parcellesPlacees,new ArrayList<Position>());
            for (Position p1:positions
                 ) {
                count=0;
                for (Parcelle p:parcellesPlacees
                     ) {
                    if(p1.estAdjacente(p.getPosition()))count++;

                }
                assertTrue(count>=2);

            }


        }


    }



}