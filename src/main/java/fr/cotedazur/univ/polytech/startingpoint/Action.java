package fr.cotedazur.univ.polytech.startingpoint;

public abstract class Action {


    protected String nomAction;
    protected String description;

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


}
