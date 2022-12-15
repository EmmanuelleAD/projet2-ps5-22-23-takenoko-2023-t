package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectifParcelle extends Objectif {

    private static List<String> ListObjectifs = new ArrayList<>(Arrays.asList("PARADJ"));
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