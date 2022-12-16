package fr.cotedazur.univ.polytech.startingpoint;

public class ActionParcelle extends Action {


    public ActionParcelle(String nomAction, Position position, String description) {
        super(nomAction, position, description);
    }

    @Override
    public String getDescription() {
        return "un joueur a placé une parcelle en "+position;
    }
}
