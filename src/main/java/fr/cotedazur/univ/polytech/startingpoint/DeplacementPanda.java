package fr.cotedazur.univ.polytech.startingpoint;

public class DeplacementPanda extends Action {


    public DeplacementPanda(String player, Personnage panda) {
        super(player,panda);
    }

    public DeplacementPanda(String nomAction, String description) {
        super(nomAction, description);
    }


    @Override
    public boolean isActionDecrementedFromPlayer() {
        return true;
    }


    @Override
    public String getDescription() {
        return null;
    }
}