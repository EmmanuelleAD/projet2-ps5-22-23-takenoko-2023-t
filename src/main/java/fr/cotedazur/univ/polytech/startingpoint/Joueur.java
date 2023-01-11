
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;
import java.util.stream.Collectors;

public class Joueur {
    public static Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    public static Comparator<Joueur> scoreComparator=Comparator.comparing(Joueur::getScore);
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



    public Action jouer(Jeu jeu) {
        if (jeu.getParcellesPlacees().size()==1)return effectuerActionParcelle(jeu);
        Random rand=new Random();
        int index=rand.nextInt(Action.getNbreAction());
        switch (index){
            case 0:   return effectuerActionParcelle(jeu);
            case 1 : return effectuerActionJardinier(jeu);
        }


        return null;
    }

    private Action effectuerActionJardinier(Jeu jeu) {
        List<Parcelle>parcelles=jeu.getParcellesPlacees();
        Random rand=new Random();
        int index;
        do
         index=rand.nextInt(jeu.getParcellesPlacees().size());
        while (index==0);
        jeu.getJardinier().move(parcelles.get(index));
       return new ActionJardinier(parcelles.get(index));


    }

    public ActionParcelle effectuerActionParcelle(Jeu jeu){
        Random rand = new Random();
        int index=rand.nextInt(jeu.getPlacementsPossibles().size());
        Parcelle parcelle1 = new Parcelle(jeu.getPlacementsPossibles().get(index));
        parcelle1.setBambou(new Bambou());
        // addScore(1);


        return new ActionParcelle(parcelle1);
    }


}
