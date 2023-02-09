package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;


public class CerveauJardinier extends Cerveau {
    public CerveauJardinier(Joueur joueur) {
        super(joueur);
    }

    public int tailleBambooParcelle(Parcelle parcelle) {
        return parcelle.getBambou().orElse(new Bambou()).getTaille();
    }

    @Override
    public Action decider(Jeu jeu,Action derniere) {
        Action newAction = getActionPiocher(jeu, derniere);
        if (newAction != null) return newAction;
        Action newAction1 = fairePousser(jeu, derniere);
        if (newAction1 != null) return newAction1;
        newAction= placerUneParcelle(jeu,derniere);
        if(newAction!=null) return newAction;
        return mangerUnBambou(jeu,derniere);
    }



    private Action fairePousser(Jeu jeu, Action derniere) {
        Action newAction;
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif = listObjectif.stream().filter(o->o.getType().equals("JARDINIER")).toList();
        for (Objectif objectif : listObjectif) {
            ObjectifJardinier obj = (ObjectifJardinier) objectif;
            if (!obj.estValide(jeu.getParcellesPlacees())) {
                List<Parcelle> copyList = new ArrayList<>(jeu.getParcellesPlacees());
                List<Parcelle> listParcelleObj = new ArrayList<>();
                for (int i = 0; i < obj.getNombre(); i++) {
                    Parcelle parcelle = Parcelle.parcelleTailleMax(Parcelle.ParcellesTailleN(copyList, obj.getTaille()));
                    if(Position.isStraightMovement(jeu.getJardinier().position, parcelle.getPosition())){
                        listParcelleObj.add(parcelle);
                        copyList.remove(parcelle);
                    }
                }
                 newAction=new ActionJardinier(Parcelle.dernier(listParcelleObj));
              if(!listParcelleObj.isEmpty()&&this.retournerAction(newAction, derniere)!=null) return newAction;
            }
        }
        return null;
    }

    private Action getActionPiocher(Jeu jeu, Action derniere) {
        if (joueur.getCartesObjectifs().isEmpty()) {
            List<ObjectifJardinier> op = jeu.getObjectifsJardinier();
            Objectif newObjectif = op.get(op.size() - 1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            if(this.retournerAction(newAction, derniere)!=null) return newAction;
        }
        return null;
    }
}



