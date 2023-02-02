package fr.cotedazur.univ.polytech.startingpoint;

public class DeplacementPanda extends Action {


    public DeplacementPanda(String player, Personnage panda) {
        super(player, panda.toString());
    }

    public DeplacementPanda(String nomAction, String description) {
        super(nomAction, description);
    }





    @Override
    public String getDescription() {
        return null;
    }
}