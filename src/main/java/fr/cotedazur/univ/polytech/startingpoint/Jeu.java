package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private List<Joueur> joueurs;
    private List<Parcelle> parcellesPlacees;
    private List<Position> placementsPossibles;
    private List<Objectif>cartesObjectis;
    private static final  int MAX_CARTES_OBJECTIFS=46;
    private int nombreObjectifs;



    public Jeu(Joueur joueur1, Joueur joueur2) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis=new ArrayList<>();
        
    }

    public void initialisation() {
        Parcelle etang = new Parcelle(new Position(0, 0));
        switch (joueurs.size()){
            case 2:
                nombreObjectifs=9;
                break;
            case 3:
                nombreObjectifs=8;
                break;
            case 4:
                nombreObjectifs=7;
                break;
        }
        parcellesPlacees.add(etang);
        Collections.sort(joueurs, Joueur.tailleComparator.reversed());
        placementsPossibles.addAll(List.of(etang.getPosition().positionsAdjacentes()));
        for (int i = 0; i <MAX_CARTES_OBJECTIFS ; i++) {
            cartesObjectis.add(ObjectifParcelle.objectifParcelles.get(0));

        }
        for (Joueur joueur:joueurs
             ) {
            joueur.getCartesObjectifs().add(cartesObjectis.get(cartesObjectis.size()-1));
            cartesObjectis.remove(cartesObjectis.size()-1);
        }
    }



  //  public void jouer() {}

    public void jouerUnTour(List<Joueur> joueurs) {


        for (Joueur j : joueurs) {
            Action action = j.jouer(placementsPossibles);
            if (action.getNomAction().equals("Parcelle")) {

                Parcelle nouvelleParcelle = new Parcelle((Position) action.getPosition());
                this.parcellesPlacees.add(nouvelleParcelle);

                placementsPossibles = Parcelle.positionsPossibleEnTenantCompteDeCellesPlacees(this.parcellesPlacees,placementsPossibles);

                System.out.println("Un joueur vient de placer une parcelle adjacente en " + action.getPosition());

                this.parcellesPlacees.add(new Parcelle((Position) action.getPosition()));
                System.out.println("le joueur "+j.getNom()+" vient de placer une parcelle adjacente en " + action.getPosition());

                ObjectifParcelle o= (ObjectifParcelle) j.getCartesObjectifs().get(0);
                if(o.estValide(parcellesPlacees)){
                    j.addScore(o.getPoints());
                    System.out.println("L'objectif "+o.getNom()+" de "+o.getPoints()+" points est validé");
                    System.out.println("le score de "+j.getNom()+" est "+j.getScore());
                    nombreObjectifs--;
                }
                if (nombreObjectifs==0){
                    j.addScore(2);
                    Joueur joueurDernierTour=j;
                    System.out.println("le joueur "+j.getNom()+" a declenché le dernier tour et remporte le bonus de 2 points");
                    List<Joueur> joueursSansGagnant=new ArrayList(joueurs);
                    joueursSansGagnant.remove(j);
                    jouerUnTour(joueursSansGagnant);
                }
            }
        }
    }

    public Joueur getGagnant(){
        Collections.sort(joueurs,Joueur.scoreComparator.reversed());
        return joueurs.get(0);
    }
    public void jouer(){
        while (nombreObjectifs>0){
            jouerUnTour(joueurs);
        }
        Joueur joueur=getGagnant();
        System.out.println(joueur.getNom()+" a gagné avec un score de " + joueur.getScore());

    }


    public static void main (String[] args){
        Joueur joueur1=new Joueur(1.85,"Wassim");
        Joueur joueur2=new Joueur(1.6,"Brahim");
        Jeu jeu=new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();


    }





}

