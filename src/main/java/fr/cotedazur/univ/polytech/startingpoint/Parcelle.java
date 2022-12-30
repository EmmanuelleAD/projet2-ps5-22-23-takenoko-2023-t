package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Math.sqrt;

public class Parcelle {
    public Position positionCentre;
    public Optional<Bambou> bambou;
    private boolean irrigue;

    public Optional<Bambou> getBambou() {
        return bambou;
    }

    public void setBambou(Bambou bambou) {
        this.bambou = Optional.ofNullable(bambou);
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



    public static List<Position> positionsPossibleEnTenantCompteDeCellesPlacees(List<Parcelle> parcellePlacees,List<Position> positionPossible) {
        Parcelle dernier=parcellePlacees.get(parcellePlacees.size()-1);
        positionPossible.addAll(List.of(dernier.getPosition().positionsAdjacentes()));
        List<Position> res=new ArrayList<>(positionPossible);
        for (int i = 0; i < positionPossible.size(); i++) {
            for (int j =0; j < parcellePlacees.size(); j++) {
                if (parcellePlacees.get(j).getPosition().equals(positionPossible.get(i))){
                    res.remove(positionPossible.get(i));
                }
            }
        }return res;
    }





}


