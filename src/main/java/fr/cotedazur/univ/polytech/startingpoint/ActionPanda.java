package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;
import java.util.Optional;

public class ActionPanda extends Action{
    public Parcelle getParcelle() {
        return parcelle;
    }

    Parcelle parcelle;

    @Override
    public String getNomAction() {
        return Type.TYPE_PANDA.getNomType();
    }

    public ActionPanda(Parcelle parcelle) {
        super(Type.TYPE_PANDA.getNomType(), "");
        this.parcelle=parcelle;
    }

    @Override
    public String getDescription() {
        String msg=(parcelle.bambou.isPresent())?". Le bambou a une taille actuelle de "+parcelle.getTaille():"";
        return " a éffectué une action PANDA en "+parcelle.getPosition() +msg;
    }

    @Override
    public boolean traiter(Joueur j, Jeu jeu) {
        if(!Position.isStraightMovement(jeu.getPanda().getPosition(), this.parcelle.getPosition())) {
            throw new IllegalArgumentException("Le PANDA peut seulement se déplacer en ligne droite ! ");
        }
       Optional<Bambou>bambouMange= jeu.getPanda().move(this.parcelle,jeu.getParcellesPlacees());
       if(bambouMange.isPresent()){
           j.getPlateau().ajouterBambou(bambouMange.get());
       }
        Jeu.logger.info(j.getNom() + this.getDescription());
        return true;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActionPanda that = (ActionPanda) o;
        return Objects.equals(parcelle, that.parcelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parcelle);
    }
}
