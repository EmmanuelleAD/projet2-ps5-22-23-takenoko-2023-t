package fr.cotedazur.univ.polytech.startingpoint;

public class Action {
    private String nomAction;
    private Position position;


    public Action(String nomAction, Position position) {
        this.nomAction = nomAction;
        this.position = position;
    }


    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
