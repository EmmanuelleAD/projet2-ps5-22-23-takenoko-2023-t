package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CerveauPanda extends Cerveau{
    public CerveauPanda(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu) {
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif = listObjectif.stream().filter(o->o.getType().equals(Type.TypePanda.getNomType())).collect(Collectors.toList());
        if (listObjectif.isEmpty()) {
            List<ObjectifPanda> op = jeu.getObjectifsPanda();
            Objectif newObjectif = op.get(op.size() - 1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            return newAction;
        }

        for (Objectif objectif : listObjectif) {
            List<Bambou>bambousJoueur=new ArrayList<>(joueur.getPlateau().getBambous());
            ObjectifPanda obj = (ObjectifPanda) objectif;
            if (!obj.estValide(jeu.getParcellesPlacees(),joueur)) {
                for (Bambou bambou: obj.getBambous()
                     ) {
                    if(bambousJoueur.contains(bambou)) bambousJoueur.remove(bambou);
                    else {
                       List<Parcelle> parcellesAvec=Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),bambou);
                       parcellesAvec=jeu.getPanda().deplacementsPossibles(parcellesAvec);
                       if(!parcellesAvec.isEmpty()) return new ActionPanda(parcellesAvec.get(0));
                    }

                }

            }
        }
        List<Position> listPlacement = jeu.getPlacementsPossibles();
        return new ActionParcelle(new Parcelle( listPlacement.get(0)));
    }
    }

