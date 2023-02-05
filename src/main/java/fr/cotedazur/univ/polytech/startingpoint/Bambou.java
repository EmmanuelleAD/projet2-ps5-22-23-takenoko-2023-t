package fr.cotedazur.univ.polytech.startingpoint;

public class Bambou {
    private int taille;
    public Bambou(){
        this.taille=1;
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
