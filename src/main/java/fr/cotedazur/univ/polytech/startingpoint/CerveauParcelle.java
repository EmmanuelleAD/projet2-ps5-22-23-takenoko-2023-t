package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CerveauParcelle extends Cerveau {

    public CerveauParcelle(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu){
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
       listObjectif= listObjectif.stream().filter(o->o.getType().equals(Type.TypeParcelle.getNomType())).collect(Collectors.toList());
        if (listObjectif.isEmpty()){
            List<ObjectifParcelle> op = jeu.getObjectifsParcelles();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction= new ActionPiocher(newObjectif);
            return newAction;
        }
        for (Objectif objectif:listObjectif
             ) {
            if(!objectif.estValide(jeu.getParcellesPlacees(),joueur)){
                ObjectifVerifier objectifVerifier=objectif.verifierValider(jeu.getParcellesPlacees());
                if(objectifVerifier.getMoinsManquants().isEmpty()) break;
                Position nouvellePos=objectifVerifier.getMoinsManquants().get(0);
                return new ActionParcelle((new Parcelle(nouvellePos)));
            }

        }


        List<Position> listPlacement = jeu.getPlacementsPossibles();
        Random ran=new Random();
        int i= ran.nextInt(listPlacement.size());
        return new ActionParcelle(new Parcelle( listPlacement.get(i)));
    }




}
