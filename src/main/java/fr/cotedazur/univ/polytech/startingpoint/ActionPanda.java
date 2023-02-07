package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Optional;

public class ActionPanda extends Action{
    Parcelle parcelle;

    @Override
    public String getNomAction() {
        return Type.TypePanda.getNomType();
    }

    public ActionPanda(Parcelle parcelle) {
        super(Type.TypePanda.getNomType(), "");
        this.parcelle=parcelle;
    }

    @Override
    public String getDescription() {
        String msg=(parcelle.bambou.isPresent())?". Le bambou a une taille actuelle de "+parcelle.getTaille():"";
        return " a éffectué une action Panda en "+parcelle.getPosition() +msg;
    }

    @Override
    public boolean traiter(Joueur j, Jeu jeu) {
        if(!Position.isStraightMovement(jeu.getPanda().getPosition(), this.parcelle.getPosition())) {
            throw new IllegalArgumentException("Le Panda peut seulement se déplacer en ligne droite ! ");
        }
       Optional<Bambou>bambouMange= jeu.getPanda().move(this.parcelle,jeu.getParcellesPlacees());
       if(bambouMange.isPresent()) j.getPlateau().ajouterBambou(bambouMange.get());
        Jeu.logger.info(j.getNom() + this.getDescription());


    }
}
