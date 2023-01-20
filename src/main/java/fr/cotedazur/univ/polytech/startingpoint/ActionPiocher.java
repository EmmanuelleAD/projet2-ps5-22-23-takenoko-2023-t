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
        return " a pioché la carte Objectif : "+objectif.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ActionPiocher)){
            return false;
        }
        ActionPiocher piocher=(ActionPiocher) o;
        return piocher.objectif.equals(this.objectif);
    }

    @Override
    public int hashCode() {
        return objectif.hashCode();
    }
}
