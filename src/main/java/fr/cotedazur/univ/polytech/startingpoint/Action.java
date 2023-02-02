package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;

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
}
