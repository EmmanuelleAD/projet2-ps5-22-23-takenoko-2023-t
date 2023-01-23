package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Random;

public class CerveauJardinier extends Cerveau {

    public CerveauJardinier(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu){
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
            }
            if (parcelle.getBambou().orElse(new Bambou()).getTaille()==3 && joueur.getCartesObjectifs().contains(ObjectifJardinier.objectifsJardinier.get(1))){
                nbParcellesBamboo2++;
            }
            if (nbParcellesBamboo2==3 && parcelle.getBambou().orElse(new Bambou()).getTaille()==2){
                return new ActionJardinier(parcelle);
            }
        }
        Random ran=new Random();
       int i= ran.nextInt(jeu.getParcellesPlacees().size());

        return new ActionJardinier(jeu.getParcellesPlacees().get(i));

    }

}
