package fr.cotedazur.univ.polytech.startingpoint;

import static java.lang.Math.sqrt;

public class Parcelle {
    public Position positionCentre;
//    public final double size=(10/sqrt(3));
//    public final double width=(sqrt(3)*size);
//    public final double height=2*size;


    public Parcelle(Position positionCentre){
        this.positionCentre=positionCentre;
    }


    public Position getPosition(){
        return positionCentre;
    }



    public boolean isAdjacent(Parcelle parcelle) {
        Position[] tabPos = positionsAdjacentes(parcelle);
        for (int i=0;i<6;i++){
            if (this.getPosition().equals(tabPos[i])){
                return true;
            }
        }return false;


    }

    public Parcelle[] parcelleAdjacentes(Parcelle parcelle) {
        Position[] tabPos = positionsAdjacentes(parcelle);
        Parcelle tabParcelle[] = new Parcelle[6];
        for (int i = 0; i < 6; i++) {
            tabParcelle[i] = new Parcelle(tabPos[i]);
        }
        return tabParcelle;
    }


    public Position[] positionsAdjacentes(Parcelle parcelle) {
        int x = this.positionCentre.getX();
        int y = this.positionCentre.getY();

        Position tabPos[] = new Position[6];
        tabPos[0] = new Position(x, y);
        tabPos[1] = new Position((x + 1), y);
        tabPos[2] = new Position(x - 1, y - 1);
        tabPos[3] = new Position(x - 1, y + 1);
        tabPos[4] = new Position(x, y - 1);
        tabPos[5] = new Position(x, y + 1);
        return tabPos;

    }

}


