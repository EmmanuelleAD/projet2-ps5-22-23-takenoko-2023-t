package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;
import java.util.Optional;

public class ActionJardinier extends Action{
    private Parcelle parcelle;
    public ActionJardinier(Parcelle p) {
        super("Jardinier", "");
        this.parcelle=p;

    }

    @Override
    public String getDescription() {
        String msg=(parcelle.bambou.isPresent())?". Le bambou a une taille actuelle de "+parcelle.getBambou().orElse(new Bambou()).getTaille():"";
        return " a éffectué une action Jardinier en " +parcelle.getPosition()+msg;
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
