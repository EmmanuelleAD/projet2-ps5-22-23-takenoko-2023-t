package fr.cotedazur.univ.polytech.startingpoint;

public class ActionParcelle extends Action {
    public Parcelle getParcelle() {
        return parcelle;
    }

    private Parcelle parcelle;


    public ActionParcelle(Parcelle p) {
        super(Type.TypeParcelle.getNomType(),  "");
        this.parcelle=p;
    }



    @Override
    public String getDescription() {
        String info=(parcelle.estIrrigue())?"irriguée en ": "non irriguée en ";
        return " vient d'éffectuer une action Parcelle .Il a  placé une parcelle "+info+parcelle.getPosition();
    }

    @Override
    public void traiter(Joueur j, Jeu jeu) {
        Parcelle nouvelleParcelle = this.getParcelle();
        jeu.getParcellesPlacees().add(nouvelleParcelle);
        jeu.setPlacementsPossibles(Parcelle.positionsPossible(jeu.getParcellesPlacees(), jeu.getPlacementsPossibles()));
        Jeu.logger.info(j.getNom() + this.getDescription());
    }
}
