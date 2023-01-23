package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;

public class ObjectifVerifier {
    boolean isManquant=false;
    List parcellesManquant = new ArrayList();


    public ObjectifVerifier(boolean isManquant, List parcellesManquant) {
        this.isManquant = isManquant;
        this.parcellesManquant = parcellesManquant;
    }


    public ObjectifVerifier() {
        this.isManquant=false;
        this.parcellesManquant = new ArrayList<>();
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
