package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Objects;

public class Bambou {
    private int taille;
    public Bambou(){
        this.taille=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bambou bambou = (Bambou) o;
        return taille == bambou.taille;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taille);
    }

    public Bambou(int taille) {
        if( taille>=0&&taille<=4)
           this.taille = taille;
    }


    public int getTaille() {
        return taille;
    }

    public void ajouterUneSection(){
        this.taille++;
    }
    public void enleverUneSection(){
        this.taille--;
    }
}
