package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;
import java.util.stream.Collectors;

public class CerveauLivraison extends Cerveau {

    public CerveauLivraison(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu) {
        if(joueur.getCartesObjectifs().isEmpty() || joueur.getCartesObjectifs().size()<5){
            List<ObjectifPanda> op = jeu.getObjectifsPanda();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            return newAction;
        }
        List<Parcelle>parcellesAvecUneSection=jeu.getParcellesPlacees().stream().filter(p->p.getTaille()>=1).collect(Collectors.toList());
        parcellesAvecUneSection=jeu.getPanda().deplacementsPossibles(parcellesAvecUneSection);
        if(!parcellesAvecUneSection.isEmpty()) return new ActionPanda(parcellesAvecUneSection.get(0));
        else{
            List<Position> listPlacement = jeu.getPlacementsPossibles();
            return new ActionParcelle(new Parcelle( listPlacement.get(0)));

        }




    }




}
