package fr.cotedazur.univ.polytech.startingpoint;

public abstract class Action {
    public String getNomAction() {
        return nomAction;
    }

    protected String nomAction;
    protected Position position;


    public abstract String getDescription();


    private String description;


    public Action(String nomAction, Position position, String description) {
        this.nomAction = nomAction;
        this.position = position;
        this.description=description;
    }




    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public Position getPosition() {return position;}

    public void setPosition(Position position) {
        this.position = position;
    }
}
