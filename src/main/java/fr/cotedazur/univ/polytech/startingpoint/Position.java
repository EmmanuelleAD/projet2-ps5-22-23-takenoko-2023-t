package fr.cotedazur.univ.polytech.startingpoint;

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

        public boolean equals(Position position) {
            return (position.x == this.x) && (position.y == this.y);
        }

//    public boolean equalsParamX(Position position,double x) {
//        return ( (position.x + x == this.x) && (position.y == this.y) ) || ((position.x - x == this.x) && (position.y == this.y));
//    }


        public static double distanceBetweenTwoPositions(Position position1, Position position2) {
            return Math.sqrt(Math.pow((double) position1.x - position2.x, 2) + Math.pow((double) position1.y - position2.y, 2));
        }

    }


