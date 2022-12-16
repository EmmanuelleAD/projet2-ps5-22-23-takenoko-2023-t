
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Joueur {
    public static Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    private double taille;
    private Plateau plateau;
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

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Joueur(double taille,String nom) {
        this.nom=nom;
        this.taille = taille;
        this.plateau = new Plateau();
        this.cartesObjectifs=new ArrayList<>();
    }


    public Action jouer(List<Position>positions) {

        Random rand = new Random();
       int index=rand.nextInt(positions.size());
        Parcelle parcelle1 = new Parcelle(positions.get(index));
        parcelle1.setBambou(new Bambou());
        addScore(1);
        return new Action("Parcelle",parcelle1.getPosition());


    }


}
