package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ObjectifVerifierParcelle extends ObjectifVerifier {
    List<List<Position>> parcellesManquant ;
    Comparator<List> tailleComparator=Comparator.comparing(List::size);


    public ObjectifVerifierParcelle(boolean isManquant, List<List<Position>> parcellesManquant) {
        this.isManquant = isManquant;
        this.parcellesManquant = parcellesManquant;
    }


    public ObjectifVerifierParcelle() {
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
            if(!manquant.contains(Parcelle.etang.getPosition())) aGarder.add(manquant);

        }
        parcellesManquant.retainAll(aGarder);
    }


    public  List<List<Position>> getParcellesManquant() {
        supprimerManquantAvecEtang();
        return parcellesManquant;
    }





}
