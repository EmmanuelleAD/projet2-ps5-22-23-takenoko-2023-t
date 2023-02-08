
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;

public class Joueur {
    public static final Comparator<Joueur> tailleComparator=Comparator.comparing(Joueur::getTaille);
    public static final Comparator<Joueur> scoreComparator=Comparator.comparing(Joueur::getScore);
    private Plateau plateau;
    private int partieGagnees=0;




    private double scoreMoyen;

    private Cerveau cerveau;

    private int partieNulles=0;

    private double taille;
    private List<Objectif>cartesObjectifs;
    private String nom;
    private int score=0;
    public int getPartieGagnees(){return partieGagnees;}
    public void setPartieGagnees(int partieGagnees){this.partieGagnees = partieGagnees;}
    public void ajoutPartieGagnees(int partieGagnees){this.partieGagnees += partieGagnees;}
    public Plateau getPlateau() {
        return plateau;
    }
    public double getScoreMoyen() {
        return scoreMoyen;
    }

    public void setScoreMoyen(int scoreMoyen) {
        this.scoreMoyen = scoreMoyen;
    }
    public void ajoutScoreMoyen(int scoreMoyen) {
        this.scoreMoyen += scoreMoyen;
    }
    public int getPartieNulles() {
        return partieNulles;
    }

    public void setPartieNulles(int partieNulles) {
        this.partieNulles = partieNulles;
    }
    public void ajoutPartieNulles(int partieNulles) {
        this.partieNulles += partieNulles;
    }
    public Cerveau getCerveau() {
        return cerveau;
    }

    public void setCerveau(Cerveau cerveau) {
        this.cerveau = cerveau;
    }

    public void addScore(int score) {
        this.score+= score;
    }
    public void setScore(int score){this.score=score;}

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
        this.plateau=new Plateau();
        this.cartesObjectifs=new ArrayList<>();
        this.scoreMoyen=0;
    }




    public Action jouer(Jeu jeu) {
        Action action1=cerveau.decider(jeu);
        action1.traiter(this,jeu);
        Action action2=cerveau.decider(jeu,action1);
        action2.traiter(this,jeu);
        return action2;
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
    public void setPlateau(Plateau plateau){
        this.plateau=plateau;
    }


}
