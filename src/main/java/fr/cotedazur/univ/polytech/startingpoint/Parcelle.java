package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Parcelle {
    public Position positionCentre;
    public Bambou bambou;
    private boolean irrigue;

    public Bambou getBambou() {
        return bambou;
    }

    public void setBambou(Bambou bambou) {
        this.bambou = bambou;
    }

    public boolean estIrrigue() {
        return irrigue;
    }
    //    public final double size=(10/sqrt(3));
//    public final double width=(sqrt(3)*size);
//    public final double height=2*size;




    public Parcelle(Position positionCentre){
        this.positionCentre=positionCentre;
        irrigue=true;
    }


    public Position getPosition(){
        return positionCentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcelle parcelle = (Parcelle) o;
        return positionCentre.equals(parcelle.positionCentre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionCentre);
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


