package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;

public class Position {
        int x;
        int y;

        public Position(int x,int y) {
            this.x = x;
            this.y =y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }



        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }


    public Position[] positionsAdjacentes() {

        Position tabPos[] = new Position[6];
        tabPos[0] = new Position(x - 1, y);
        tabPos[1] = new Position(x + 1, y);
        tabPos[2] = new Position(x, y - 1);
        tabPos[3] = new Position(x, y + 1);

        if  ((this.y)%2==1){
            tabPos[4] = new Position(x - 1, y - 1);
            tabPos[5] = new Position(x - 1, y + 1);
        }else{
            tabPos[4] = new Position(x + 1, y - 1);
            tabPos[5] = new Position(x + 1, y + 1);
        }
        return tabPos;

    }
    public boolean estAdjacente(Position p){
        for (Position p1:positionsAdjacentes()
             ) {
            if(p1.equals(p))return true;
        }
            return false;
    }



    public boolean positionEnLigneDroite(Position p1,Position p2, Position p3){
           if(   ( p1.getX()+1==p2.getX() && p2.getX()+1==p3.getX() && p1.getY()==p2.getY() && p1.getY()==p3.getY() ) ||
                   ( p1.getX()==p2.getX() && p2.getX()+1==p3.getX() && p1.getY()+1==p2.getY() && p2.getY()+1==p3.getY() )   ||
                   ( p1.getX()==p2.getX() && p2.getX()+1==p3.getX() && p1.getY()+1==p2.getY() && p2.getY()+1==p3.getY() ) )  {
               return true;
           }return false;
    }




    }


