package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;

public class ObjectifJardinier extends Objectif {

    private int taille;
    private int nombre;


    public ObjectifJardinier(String nom,int taille , int nombre, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.taille = taille;
        this.nombre=nombre;
    }


    public int getTaille(){
        return this.taille;
    }

    @Override
    public String toString() {
        return super.toString() + " : Pousser " + this.nombre + " " + " Bambou de taille " + this.taille + " (" +  ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectifJardinier)) return false;
        ObjectifJardinier o = (ObjectifJardinier) obj;
        return super.equals(obj) && o.taille == this.taille && o.nombre == this.nombre;
    }

    @Override
    public boolean estValide(List<Parcelle> parcelles) {
        return false;
    }
}
