package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Objects;

public abstract class Objectif{
    protected String nom;
    protected int points ;
    protected boolean statut;
    protected String description ;

    public String getType() {
        return type;
    }

    protected String type;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom!=null&& !nom.isEmpty())
            this.nom = nom;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if(points>0)
            this.points = points;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    protected Objectif(String nom, int points, boolean statut, String description) {
        this.nom = nom;
        this.points = points;
        this.statut = statut;
        this.description = description;
    }



    public abstract boolean estValide(List<Parcelle> parcelles,Joueur joueur);
    public abstract  ObjectifVerifier verifierValider(List<Parcelle>parcelles);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objectif objectif = (Objectif) o;

        if (points != objectif.points) return false;
        if (statut != objectif.statut) return false;
        if (!Objects.equals(nom, objectif.nom)) return false;
        if (!Objects.equals(description, objectif.description))
            return false;
        return Objects.equals(type, objectif.type);
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + points;
        result = 31 * result + (statut ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
