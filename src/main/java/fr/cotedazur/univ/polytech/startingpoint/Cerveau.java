package fr.cotedazur.univ.polytech.startingpoint;


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





}
