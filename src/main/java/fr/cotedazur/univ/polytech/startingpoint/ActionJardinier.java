package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Optional;

public class ActionJardinier extends Action{
    private Parcelle parcelle;
    public ActionJardinier(Parcelle p) {
        super("Jardinier", "");
        this.parcelle=p;

    }

    @Override
    public String getDescription() {
        String msg=(parcelle.bambou.isPresent())?". Le bambou en un taille actuelle de "+parcelle.getBambou().orElse(new Bambou()).getTaille():"";
        return " a éffectué une action Jardinier en " +parcelle.getPosition()+msg;
    }
}
