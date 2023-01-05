package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectifParcelle extends Objectif {

    static List<ObjectifParcelle> objectifParcelles = new ArrayList<>(Arrays.asList(
            new ObjectifParcelle("PARADJ",2,false,""),
            new ObjectifParcelle("POUSSB",2,false,"")));
    public ObjectifParcelle(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.type="Parcelle";
    }


    @Override
    public boolean estValide(List<Parcelle> parcelles) {
        switch (getNom()) {
            case "PARADJ":
                return verifierValiderPARADJ(parcelles);
            case "POUSSB":
                return verifierValiderPOUSSB(parcelles);


        }
        return false;
    }

    private boolean verifierValiderPOUSSB(List<Parcelle> parcelles) {
        if (parcelles.get(parcelles.size()-1).getBambou().isPresent()) return true;
        return false;
    }

    private boolean verifierValiderPARADJ(List<Parcelle> parcelles) {
        for (Parcelle p:parcelles
             ) {
            if(p.isAdjacent(parcelles.get(parcelles.size() - 1)))
                return true;
        }
        return false;
    }


}