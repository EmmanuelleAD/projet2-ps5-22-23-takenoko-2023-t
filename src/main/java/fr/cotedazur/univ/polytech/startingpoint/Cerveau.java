package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Collection;
import java.util.List;

public class Cerveau {
    public Joueur joueur;

    public Cerveau(Joueur joueur) {
        this.joueur=joueur;
    }


    public Action decider(Jeu jeu){
            if (joueur.getCartesObjectifs().size()==0){
                List<ObjectifParcelle> op = jeu.getObjectifsParcelles();
                Objectif newObjectif = op.get(op.size()-1);
                ActionPiocher newAction= new ActionPiocher(newObjectif);
                return newAction;

        }
        return null;
    }



    public Action deciderJardinier(Jeu jeu){
        if (joueur.getCartesObjectifs().size()==0){
            List<ObjectifJardinier> op = jeu.getObjectifsJardinier();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction= new ActionPiocher(newObjectif);
            return newAction;
        }
        int nbParcellesBamboo2=0;
        for (Parcelle parcelle : jeu.getParcellesPlacees()){
            if (parcelle.getBambou().orElse(new Bambou()).getTaille()==3 && joueur.getCartesObjectifs().contains(ObjectifJardinier.objectifsJardinier.get(0))){
                return new ActionJardinier(parcelle);
            } if (parcelle.getBambou().orElse(new Bambou()).getTaille()==3 && joueur.getCartesObjectifs().contains(ObjectifJardinier.objectifsJardinier.get(1))){
                nbParcellesBamboo2++;
                if (nbParcellesBamboo2==2 && parcelle.getBambou().orElse(new Bambou()).getTaille()==2){
                    return new ActionJardinier(parcelle);
                }
            }
        }
        return new ActionParcelle(new Parcelle(jeu.getPlacementsPossibles().get(0)));

    }



}
