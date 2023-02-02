
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;
import java.util.stream.Collectors;

public class Joueur {
    public static Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    public static Comparator<Joueur> scoreComparator=Comparator.comparing(Joueur::getScore);
    private double taille;
    private List<Objectif>cartesObjectifs;
    private String nom;



    private Cerveau cerveau;

    public Cerveau getCerveau() {
        return cerveau;
    }

    public void setCerveau(Cerveau cerveau) {
        this.cerveau = cerveau;
    }

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




    public Action jouer(Jeu jeu) {
        return cerveau.decider(jeu);
    }

    private Action piocherCartesObjectifs(Jeu jeu) {
        Random rand=new Random();
        int index=rand.nextInt(2);
        int size;
        Objectif o;
        if(index==0){
            size=jeu.getObjectifsParcelles().size();
             o=jeu.getObjectifsParcelles().get(rand.nextInt(size));
        }
       else {
            size=jeu.getObjectifsJardinier().size();
            o=jeu.getObjectifsJardinier().get(rand.nextInt(size));
        }
        return new ActionPiocher(o);
    }

    private Action effectuerActionJardinier(Jeu jeu) {
        List<Parcelle>parcelles=jeu.getParcellesPlacees();
        Random rand=new Random();
        int index;
        do
         index=rand.nextInt(jeu.getParcellesPlacees().size());
        while (index==0);
        jeu.getJardinier().move(parcelles.get(index),jeu.getParcellesPlacees());
       return new ActionJardinier(parcelles.get(index));

    }

    public ActionParcelle effectuerActionParcelle(Jeu jeu){
        Random rand = new Random();
        int index=rand.nextInt(jeu.getPlacementsPossibles().size());
        Parcelle parcelle1 = new Parcelle(jeu.getPlacementsPossibles().get(index));
        parcelle1.setBambou(new Bambou());


        return new ActionParcelle(parcelle1);
    }


}
