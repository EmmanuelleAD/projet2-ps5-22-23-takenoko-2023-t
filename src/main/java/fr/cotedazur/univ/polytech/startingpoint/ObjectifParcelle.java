package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectifParcelle extends Objectif {

    static List<ObjectifParcelle> objectifParcelles = new ArrayList<>(Arrays.asList(new ObjectifParcelle("PARADJ",2,false,"")));
    public ObjectifParcelle(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
    }


    @Override
    public boolean estValide(List<Parcelle> parcelles) {
        switch (getNom()) {
            case "PARADJ":
                return verifierValiderPARADJ(parcelles);

        }
        return false;
    }

    private boolean verifierValiderPARADJ(List<Parcelle> parcelles) {
        return parcelles.get(parcelles.size() - 1).isAdjacent(new Parcelle(new Position(0, 0)));
    }


}