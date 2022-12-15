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
        Position[] tabPos = parcelle.getPosition().positionsAdjacentes();
        for (int i=0;i<6;i++){
            if (this.getPosition().equals(tabPos[i])){
                return true;
            }
        }return false;


    }

    public Parcelle[] parcelleAdjacentes() {
        Position[] tabPos = this.getPosition().positionsAdjacentes();
        Parcelle tabParcelle[] = new Parcelle[6];
        for (int i = 0; i < 6; i++) {
            tabParcelle[i] = new Parcelle(tabPos[i]);
        }
        return tabParcelle;
    }




}


