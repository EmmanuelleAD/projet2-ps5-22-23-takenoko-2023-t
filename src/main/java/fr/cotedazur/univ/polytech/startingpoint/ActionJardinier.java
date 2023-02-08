package fr.cotedazur.univ.polytech.startingpoint;


import java.util.Objects;

public class ActionJardinier extends Action{
    public Parcelle getParcelle() {
        return parcelle;
    }

    private final Parcelle parcelle;
    public ActionJardinier(Parcelle p) {
        super(Type.TYPE_JARDINIER.getNomType(), "");
        this.parcelle=p;

    }

    @Override
    public String getDescription() {
        String msg=(parcelle.bambou.isPresent())?". Le bambou a une taille actuelle de "+parcelle.getTaille():"";
        return " a effectue une action JARDINIER en " +parcelle.getPosition()+msg;
    }

    @Override
    public boolean traiter(Joueur joueur, Jeu jeu) {
        if(!Position.isStraightMovement(jeu.getJardinier().getPosition(), this.parcelle.getPosition())) {
            throw new IllegalArgumentException("Le jardinier peut seulement se déplacer en ligne droite ! ");
        }
        jeu.getJardinier().move(this.getParcelle(),jeu.getParcellesPlacees());

        Jeu.logger.info(joueur.getNom() + this.getDescription());
        return true;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActionJardinier that = (ActionJardinier) o;
        return Objects.equals(parcelle, that.parcelle);
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (parcelle != null ? parcelle.hashCode() : 0);
        return result;
    }
}