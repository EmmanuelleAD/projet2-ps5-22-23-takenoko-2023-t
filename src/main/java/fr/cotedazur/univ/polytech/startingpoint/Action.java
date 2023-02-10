package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;

public abstract class Action {


    protected String nomAction;
    protected String description;
    private final static int NBRE_ACTION =3;




    public abstract String getDescription();
    public String getNomAction() {
        return nomAction;
    }




    public abstract boolean traiter(Joueur j, Jeu jeu);





    protected Action(String nomAction,  String description) {
        this.nomAction = nomAction;
        this.description=description;
    }





    public static int getNbreAction() {
        return NBRE_ACTION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        return Objects.equals(nomAction, action.nomAction);

    }

    @Override
    public int hashCode() {
        return nomAction != null ? nomAction.hashCode() : 0;
    }
}
