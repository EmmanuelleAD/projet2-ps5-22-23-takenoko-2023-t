package fr.cotedazur.univ.polytech.startingpoint;

public class Action {
    private String nomAction;
    private Position position;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;


    public Action(String nomAction, Position position, String description) {
        this.nomAction = nomAction;
        this.position = position;
        this.description=description;
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
