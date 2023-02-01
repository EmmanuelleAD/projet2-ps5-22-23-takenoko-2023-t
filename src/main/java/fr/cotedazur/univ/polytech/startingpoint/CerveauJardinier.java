package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class CerveauJardinier extends Cerveau {
    public CerveauJardinier(Joueur joueur) {
        super(joueur);
    }

    public int tailleBambooParcelle(Parcelle parcelle) {
        return parcelle.getBambou().orElse(new Bambou()).getTaille();
    }

    @Override
    public Action decider(Jeu jeu) {
        if (joueur.getCartesObjectifs().isEmpty()) {
            List<ObjectifJardinier> op = jeu.getObjectifsJardinier();
            Objectif newObjectif = op.get(op.size() - 1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            return newAction;
        }
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif = listObjectif.stream().filter(o->o.getType().equals("Jardinier")).collect(Collectors.toList());
        for (Objectif objectif : listObjectif) {
            ObjectifJardinier obj = (ObjectifJardinier) objectif;
            if (!obj.estValide(jeu.getParcellesPlacees())) {
                List<Parcelle> copyList = jeu.getParcellesPlacees().stream().collect(Collectors.toList());
                List<Parcelle> listParcelleObj = new ArrayList<>();
                for (int i = 0; i < obj.getNombre(); i++) {
                    Parcelle parcelle = Parcelle.parcelleTailleMax(Parcelle.ParcellesTailleN(copyList, obj.getTaille()));
                    listParcelleObj.add(parcelle);
                    copyList.remove(parcelle);
                }
                return new ActionJardinier(listParcelleObj.get(listParcelleObj.size() - 1));
            }
        }
        List<Position> listPlacement = jeu.getPlacementsPossibles();
        return new ActionParcelle(new Parcelle( listPlacement.get(0)));
    }
}



