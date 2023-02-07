package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;
import java.util.stream.Collectors;

public class CerveauLivraison extends Cerveau {
    int i=0;
    public int getI(){
        return i%2;

    }

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
        List<Objectif> objectifBambou = joueur.getCartesObjectifs();
        objectifBambou = objectifBambou.stream().filter(o->o.getType().equals(Type.TypePanda.getNomType())).collect(Collectors.toList()).subList(0,2);
        List<Bambou>bambousJoueur=new ArrayList<>(joueur.getPlateau().getBambous());
        if(!objectifBambou.isEmpty() && (objectifBambou.size() >= 2)){
            ObjectifPanda obj=(ObjectifPanda) objectifBambou.get(i%2);
            i++;
            if (!obj.estValide(jeu.getParcellesPlacees(),joueur)) {
                Action parcellesAvec = CerveauPanda.getActionObjectif(jeu, bambousJoueur, obj);

                if (parcellesAvec != null) {

                    return parcellesAvec;
                }

            }

        } else if (objectifBambou.size()==1) {
            Action parcellesAvec = CerveauPanda.getActionObjectif(jeu, bambousJoueur,(ObjectifPanda) objectifBambou.get(0));
            if (parcellesAvec != null) return parcellesAvec;
            
        }
        List<Parcelle>parcellesAvecUneSection=jeu.getParcellesPlacees().stream().filter(p->p.getTaille()>=1).collect(Collectors.toList());
        parcellesAvecUneSection=jeu.getPanda().deplacementsPossibles(parcellesAvecUneSection);
        if(!parcellesAvecUneSection.isEmpty()) return new ActionPanda(parcellesAvecUneSection.get(0));
            List<Position> listPlacement = jeu.getPlacementsPossibles();
            return new ActionParcelle(new Parcelle( listPlacement.get(0)));






    }




}
