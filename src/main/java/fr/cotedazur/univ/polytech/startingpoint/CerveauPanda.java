package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;


public class CerveauPanda extends Cerveau{
    public CerveauPanda(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu,Action derniere) {
        ActionPiocher newAction = piocherUneCarte(jeu, derniere);
        if (newAction != null) {return newAction;}
        Action parcellesAvec = mangerBambou(jeu, derniere);
        if (parcellesAvec != null) {return parcellesAvec;}
         parcellesAvec = pousserBambou(jeu, derniere);
        if (parcellesAvec != null) return parcellesAvec;
        Action action= placerUneParcelle(jeu,derniere);
        if(action!=null)return  action;
        action = super.mangerUnBambou(jeu,derniere);
        if(action!=null){
            return action;
        }
        return placerUneParcelle(jeu,null);
    }
    private Action pousserBambou(Jeu jeu ,Action derniere){
        List<Parcelle>parcelles=jeu.getJardinier().deplacementsPossibles(jeu.getParcellesPlacees());
        Action action=new ActionJardinier(parcelles.get(0));
        if(this.retournerAction(action, derniere)!=null)   return action;
        return null;
    }

    private Action mangerBambou(Jeu jeu, Action derniere) {
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif = listObjectif.stream().filter(o->o.getType().equals(Type.TYPE_PANDA.getNomType())).toList();

        for (Objectif objectif : listObjectif) {
            List<Bambou>bambousJoueur=new ArrayList<>(joueur.getPlateau().getBambous());
            ObjectifPanda obj = (ObjectifPanda) objectif;
            if (!obj.estValide(jeu.getParcellesPlacees(),joueur)) {
                Action parcellesAvec = getActionObjectif(jeu, bambousJoueur, obj);
                if (parcellesAvec != null&& (this.retournerAction(parcellesAvec, derniere)!=null) )
                    return parcellesAvec;

            }
        }
        return null;
    }

    private  ActionPiocher piocherUneCarte(Jeu jeu, Action derniere) {
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif = listObjectif.stream().filter(o->o.getType().equals(Type.TYPE_PANDA.getNomType())).toList();
        if (listObjectif.isEmpty()) {
            List<ObjectifPanda> op = jeu.getObjectifsPanda();
            Objectif newObjectif = op.get(op.size() - 1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            if(this.retournerAction(newAction, derniere)!=null)   return newAction;
        }
        return null;
    }

    static Action getActionObjectif(Jeu jeu, List<Bambou> bambousJoueur, ObjectifPanda obj) {
        for (Bambou bambou: obj.getBambous()
             ) {
            if(bambousJoueur.contains(bambou)) bambousJoueur.remove(bambou);
            else {
               List<Parcelle> parcellesAvec=Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),bambou);
               parcellesAvec=jeu.getPanda().deplacementsPossibles(parcellesAvec);
               if(!parcellesAvec.isEmpty()) return new ActionPanda(parcellesAvec.get(0));
            }

        }
        return null;
    }

}

