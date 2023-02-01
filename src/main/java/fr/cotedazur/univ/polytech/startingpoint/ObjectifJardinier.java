package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectifJardinier extends Objectif {
    static List<ObjectifJardinier> objectifsJardinier=new ArrayList<>(Arrays.asList(
            new ObjectifJardinier("B14",20,false,"1 Bambou de Taille 4",4,1),
            new ObjectifJardinier("B43",6,false,"4 Bambous de taille 3",3,4)));

    private int taille;
    private int nombre;


    public ObjectifJardinier(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.type="Jardinier";
    }

    public ObjectifJardinier(String nom, int points, boolean statut, String description, int taille , int nombre) {
        super(nom, points, statut, description);
        this.taille = taille;
        this.nombre=nombre;
    }


    public int getTaille(){
        return this.taille;
    }
    public int getNombre(){return this.nombre;}
    public String getType(){
        return "Jardinier";
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
        int i=0;
        for (Parcelle p:parcelles
             ) {

            if(p.getTaille()==this.taille) i++;

            if(i==nombre)return true;

        }
     return false;
    }


}
