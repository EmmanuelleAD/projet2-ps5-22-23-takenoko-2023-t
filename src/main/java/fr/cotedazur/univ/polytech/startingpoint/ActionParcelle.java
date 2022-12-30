package fr.cotedazur.univ.polytech.startingpoint;

public class ActionParcelle extends Action {
    public Parcelle getParcelle() {
        return parcelle;
    }

    private Parcelle parcelle;


    public ActionParcelle(Parcelle p) {
        super("Parcelle",  "");
        this.parcelle=p;
    }

    @Override
    public String getDescription() {
        String info=(parcelle.estIrrigue())?"irriguée en ": "non irriguée en ";
        return " vient de placer une parcelle "+info+parcelle.getPosition();
    }
}
