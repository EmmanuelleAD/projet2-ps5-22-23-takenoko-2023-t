package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Random;

public class CerveauParcelle extends Cerveau {

    public CerveauParcelle(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu){
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        if (joueur.getCartesObjectifs().size()==0){
            List<ObjectifParcelle> op = jeu.getObjectifsParcelles();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction= new ActionPiocher(newObjectif);
            return newAction;
        }



         if (listObjectif.contains(ObjectifParcelle.objectifParcelles.get(0))  && !ObjectifParcelle.objectifParcelles.get(0).estValide(jeu.getParcellesPlacees())) {
             ObjectifVerifier objectifVerifier = ObjectifParcelle.verifierValiderAli3(jeu.getParcellesPlacees());
             ObjectifVerifier ov= ObjectifParcelle.verifierValiderAli3(jeu.getParcellesPlacees());
             Position position = ov.getParcellesManquant().get(0).get(0);
             return new ActionParcelle(new Parcelle(position));
         }
        if (listObjectif.contains(ObjectifParcelle.objectifParcelles.get(1))  && !ObjectifParcelle.objectifParcelles.get(0).estValide(jeu.getParcellesPlacees())) {
            ObjectifVerifier objectifVerifier = ObjectifParcelle.verifierValiderPARC(jeu.getParcellesPlacees());
            ObjectifVerifier ov= ObjectifParcelle.verifierValiderPARC(jeu.getParcellesPlacees());
            Position position = ov.getParcellesManquant().get(0).get(0);
            return new ActionParcelle(new Parcelle(position));
        }
        if (listObjectif.contains(ObjectifParcelle.objectifParcelles.get(2))  && !ObjectifParcelle.objectifParcelles.get(0).estValide(jeu.getParcellesPlacees())) {
            ObjectifVerifier objectifVerifier = ObjectifParcelle.verifierValiderPARC(jeu.getParcellesPlacees());
            ObjectifVerifier ov= ObjectifParcelle.verifierValiderGRP3(jeu.getParcellesPlacees());
            Position position = ov.getParcellesManquant().get(0).get(0);
            return new ActionParcelle(new Parcelle(position));
        }
        if (listObjectif.contains(ObjectifParcelle.objectifParcelles.get(3))  && !ObjectifParcelle.objectifParcelles.get(0).estValide(jeu.getParcellesPlacees())) {
            ObjectifVerifier objectifVerifier = ObjectifParcelle.verifierValiderPARC(jeu.getParcellesPlacees());
            ObjectifVerifier ov= ObjectifParcelle.verifierValiderGRP4(jeu.getParcellesPlacees());
            Position position = ov.getParcellesManquant().get(0).get(0);
            return new ActionParcelle(new Parcelle(position));
        }

        List<Position> listPlacement = jeu.getPlacementsPossibles();
        Random ran=new Random();
        int i= ran.nextInt(listPlacement.size());
        return new ActionParcelle(new Parcelle( listPlacement.get(i)));
    }




}
