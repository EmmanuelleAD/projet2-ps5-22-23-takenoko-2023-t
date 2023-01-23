package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;

public class ObjectifVerifier {
    boolean isManquant=false;
    List<List<Position>> parcellesManquant = new ArrayList();


    public ObjectifVerifier(boolean isManquant, List<List<Position>> parcellesManquant) {
        this.isManquant = isManquant;
        this.parcellesManquant = parcellesManquant;
    }


    public ObjectifVerifier() {
        this.isManquant=false;
        this.parcellesManquant = new ArrayList<>();
    }
    public void ajoutManquants(List<Position>positions){
        this.parcellesManquant.add(positions);

    }



    public boolean isManquant() {
        return isManquant;
    }

    public List getParcellesManquant() {
        return parcellesManquant;
    }


    public void setIsManquant(boolean isManquant) {
        this.isManquant=isManquant;
    }



}
