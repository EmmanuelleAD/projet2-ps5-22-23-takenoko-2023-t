package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Optional;

public class ActionPanda extends Action{
    Parcelle parcelle;
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
    public void traiter(Joueur j, Jeu jeu) {
       Optional<Bambou>bambouMange= jeu.getPanda().move(this.parcelle,jeu.getParcellesPlacees());
       if(bambouMange.isPresent()) j.getPlateau().ajouterBambou(bambouMange.get());
        System.out.println(j.getNom() + this.getDescription());


    }
}
