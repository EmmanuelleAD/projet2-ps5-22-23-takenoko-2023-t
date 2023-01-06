
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Joueur {
    public static Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    public static Comparator<Joueur> scoreComparator=Comparator.comparing(Joueur::getScore);
    private double taille;
    private List<Objectif>cartesObjectifs;
    private String nom;

    private int score=0;

    public void addScore(int score) {
        this.score+= score;
    }

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Objectif> getCartesObjectifs() {
        return cartesObjectifs;
    }

    public void setCartesObjectifs(List<Objectif> cartesObjectifs) {
        this.cartesObjectifs = cartesObjectifs;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }


    public Joueur(double taille,String nom) {
        this.nom=nom;
        this.taille = taille;
        this.cartesObjectifs=new ArrayList<>();
    }



    public Action jouer(List<Position>positions) {

        Random rand = new Random();
       int index=rand.nextInt(positions.size());
        Parcelle parcelle1 = new Parcelle(positions.get(index));
        parcelle1.setBambou(new Bambou());
       // addScore(1);


        return new ActionParcelle(parcelle1);

    }


}
