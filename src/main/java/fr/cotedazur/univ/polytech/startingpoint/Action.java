package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Objects;

public abstract class Action {


    protected String nomAction;
    protected String description;
    private final static int  nbreAction=3;

    public abstract String getDescription();
    public String getNomAction() {
        return nomAction;
    }





    public Action(String nomAction,  String description) {
        this.nomAction = nomAction;
        this.description=description;
    }




    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }


    public static int getNbreAction() {
        return nbreAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (!Objects.equals(nomAction, action.nomAction)) return false;
        return Objects.equals(description, action.description);
    }

    @Override
    public int hashCode() {
        int result = nomAction != null ? nomAction.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
