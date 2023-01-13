package fr.cotedazur.univ.polytech.startingpoint;

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
        }
        return null;
    }





}
