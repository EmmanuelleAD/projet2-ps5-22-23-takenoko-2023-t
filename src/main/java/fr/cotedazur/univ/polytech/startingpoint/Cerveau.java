package fr.cotedazur.univ.polytech.startingpoint;


import java.util.List;

public abstract class Cerveau {
    protected Joueur joueur;

    protected Cerveau(Joueur joueur) {
        this.joueur=joueur;
    }
    public Action retournerAction(Action action,Action derniere){
        if(derniere==null||!derniere.getNomAction().equals(action.nomAction)) {
            return action;
        }
        return  null;
    }

    public Action decider(Jeu jeu) {
        return decider(jeu, null);
    }

    public abstract Action decider(Jeu jeu,Action derniere);
    protected Action mangerUnBambou(Jeu jeu,Action derniere){
        List<Parcelle> parcellesAvec=Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),new Bambou(1));
        parcellesAvec=jeu.getPanda().deplacementsPossibles(parcellesAvec);
        if(!parcellesAvec.isEmpty()) {
            Action action = new ActionPanda(parcellesAvec.get(0));
            if (this.retournerAction(action, derniere) != null)return action;
        }
        return null;
    }
    protected Action placerUneParcelle(Jeu jeu, Action derniere) {
        List<Position> listPlacement = jeu.getPlacementsPossibles();
      if(!listPlacement.isEmpty()){
          Action action=new ActionParcelle(new Parcelle( listPlacement.get(0)));
        if(this.retournerAction(action, derniere)!=null) return action;}
        return null;
    }





}
