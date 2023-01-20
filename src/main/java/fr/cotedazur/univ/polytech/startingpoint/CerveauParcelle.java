package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Random;

public class CerveauParcelle extends Cerveau {

    public CerveauParcelle(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu){
        if (joueur.getCartesObjectifs().size()==0){
            List<ObjectifParcelle> op = jeu.getObjectifsParcelles();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction= new ActionPiocher(newObjectif);
            return newAction;

        }

        List<Position> listPlacement = jeu.getPlacementsPossibles();
        Random ran=new Random();
        int i= ran.nextInt(listPlacement.size());
        return new ActionParcelle(new Parcelle( listPlacement.get(i)));
    }


}
