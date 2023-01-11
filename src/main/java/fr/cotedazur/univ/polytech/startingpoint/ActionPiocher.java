package fr.cotedazur.univ.polytech.startingpoint;

public class ActionPiocher extends Action{
    public Objectif getObjectif() {
        return objectif;
    }

    private Objectif objectif;
    public ActionPiocher(Objectif objectif) {
        super("Piocher", "");
        this.objectif=objectif;
    }

    @Override
    public String getDescription() {
        return "a pioché la carte Objectif : "+objectif.getDescription();
    }
}
