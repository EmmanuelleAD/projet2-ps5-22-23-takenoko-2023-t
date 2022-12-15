
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Joueur {
    public static Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    private double taille;
    private Plateau plateau;
    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }




    public Joueur(double taille) {
        this.taille = taille;
        this.plateau = new Plateau();
    }

    public List jouer() {
        List list = new ArrayList();
        Random rand = new Random();
        int x = rand.nextInt();
        int y = rand.nextInt();
        Position positionParcelle1 = new Position(x, y);
        Parcelle parcelle1 = new Parcelle(positionParcelle1);
        list.add("Parcelle");
        list.add(parcelle1.getPosition());
        return list;


    }


}
