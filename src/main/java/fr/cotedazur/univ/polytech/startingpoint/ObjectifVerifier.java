package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ObjectifVerifier {
    boolean isManquant=false;
    List<List<Position>> parcellesManquant = new ArrayList();
    Comparator<List> tailleComparator=Comparator.comparing(List::size);


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
    public List<Position>getMoinsManquants(){
        supprimerManquantAvecEtang();
    Optional<List<Position>> min;
        min = parcellesManquant.stream().min(tailleComparator);
        return min.orElse(new ArrayList<>());
    }
    private void supprimerManquantAvecEtang(){
        List<List<Position>> aGarder=new ArrayList<>();
        for (List<Position>manquant:parcellesManquant
             ) {
            if(!manquant.contains(Parcelle.etang)) aGarder.add(manquant);

        }
        parcellesManquant.retainAll(aGarder);
    }



    public boolean isManquant() {
        return isManquant;
    }

    public  List<List<Position>> getParcellesManquant() {
        supprimerManquantAvecEtang();
        return parcellesManquant;
    }


    public void setIsManquant(boolean isManquant) {
        this.isManquant=isManquant;
    }



}
