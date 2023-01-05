package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;

public class Position {
        int x;
        int y;
        private static final double EPSILON = 0.001;


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

        public boolean isEquivalent(Position position) {
            double xEquiv = Math.abs(position.x - this.x);
            double yEquiv = Math.abs(position.y - this.y);
            return xEquiv <= EPSILON && yEquiv <= EPSILON;
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





        public static double distanceBetweenTwoPositions(Position position1, Position position2) {
            return Math.sqrt(Math.pow((double) position1.x - position2.x, 2) + Math.pow((double) position1.y - position2.y, 2));
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

    }


