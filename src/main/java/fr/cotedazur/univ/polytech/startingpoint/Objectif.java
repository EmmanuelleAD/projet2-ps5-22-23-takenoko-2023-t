package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;

public abstract class Objectif{
    private String nom;
    private int points ;
    private boolean statut;
    private String description ;

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



    public Objectif(String nom, int points, boolean statut, String description) {
        this.nom = nom;
        this.points = points;
        this.statut = statut;
        this.description = description;
    }



    public abstract boolean estValide(List<Parcelle> parcelles);
}
