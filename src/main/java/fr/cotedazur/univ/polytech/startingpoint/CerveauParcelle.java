package fr.cotedazur.univ.polytech.startingpoint;


import java.util.List;
import java.util.Random;


public class CerveauParcelle extends Cerveau {

    public CerveauParcelle(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu,Action derniere){
        Action newAction = piocherUneCarte(jeu, derniere);
        if (newAction != null) return newAction;
        newAction = placerUneParcelle(jeu, derniere);
        if (newAction != null) return newAction;
        newAction = mangerUnBambou(jeu, derniere);
        if (newAction != null) return newAction;
        newAction = pousserBambou(jeu, derniere);
        if (newAction != null) return newAction;

        return placerUneParcelleRandom(jeu,derniere);
    }

    public static final Random ran=new Random();

    private  Action placerUneParcelleRandom(Jeu jeu,Action derniere) {
        List<Position> listPlacement = jeu.getPlacementsPossibles();
        int i= ran.nextInt(listPlacement.size());
        Action action= new ActionParcelle(new Parcelle(listPlacement.get(i)));
        if(this.retournerAction(action, derniere)!=null) return action;
        return null;
    }
    private Action pousserBambou(Jeu jeu ,Action derniere){
        List<Parcelle>parcelles=jeu.getJardinier().deplacementsPossibles(jeu.getParcellesPlacees());
        Action action=new ActionJardinier(parcelles.get(0));
        if(this.retournerAction(action, derniere)!=null)   return action;
        return null;
    }
    private Action mangerUnBambou(Jeu jeu,Action derniere){
        List <Parcelle>parcellesAvec=Parcelle.getParcellesAvec(jeu.getParcellesPlacees(),new Bambou(1));
        parcellesAvec=jeu.getPanda().deplacementsPossibles(parcellesAvec);
        if(!parcellesAvec.isEmpty()) {
            Action action = new ActionPanda(parcellesAvec.get(0));
            if (this.retournerAction(action, derniere) != null)return action;
        }
        return null;
    }

    private ActionParcelle placerUneParcelle(Jeu jeu, Action derniere) {
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif= listObjectif.stream().filter(o->o.getType().equals(Type.TYPE_PARCELLE.getNomType())).toList();
        for (Objectif objectif: listObjectif
             ) {
            if(!objectif.estValide(jeu.getParcellesPlacees(),joueur)){
                ObjectifVerifierParcelle objectifVerifier= (ObjectifVerifierParcelle) objectif.verifierValider(jeu.getParcellesPlacees());
                if(objectifVerifier.getMoinsManquants().isEmpty()) break;
                Position nouvellePos=objectifVerifier.getMoinsManquants().get(0);
                return new ActionParcelle((new Parcelle(nouvellePos)));
            }

        }
        return null;
    }

    private  ActionPiocher piocherUneCarte(Jeu jeu, Action derniere) {
        List<Objectif> listObjectif = joueur.getCartesObjectifs();
        listObjectif= listObjectif.stream().filter(o->o.getType().equals(Type.TYPE_PARCELLE.getNomType())).toList();
        if (listObjectif.isEmpty()){
            List<ObjectifParcelle> op = jeu.getObjectifsParcelles();
            Objectif newObjectif = op.get(op.size()-1);
            ActionPiocher newAction= new ActionPiocher(newObjectif);
            if(this.retournerAction(newAction, derniere)!=null) return newAction;
        }
        return null;
    }


}
