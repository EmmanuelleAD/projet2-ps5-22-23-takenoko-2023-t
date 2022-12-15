package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private List<Joueur> joueurs;
    private List<Parcelle> parcellesPlacees;
    private List<Position> placementsPossibles;
    private List<Objectif>cartesObjectis;
    private static final  int MAX_OBJ=46;



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
        parcellesPlacees.add(etang);
        Collections.sort(joueurs, Joueur.tailleComparator);
        placementsPossibles.addAll(List.of(etang.getPosition().positionsAdjacentes()));
        for (int i = 0; i <MAX_OBJ ; i++) {
            cartesObjectis.add(ObjectifParcelle.objectifParcelles.get(0));

        }
        for (Joueur joueur:joueurs
             ) {
            joueur.getCartesObjectifs().add(cartesObjectis.get(cartesObjectis.size()-1));
            cartesObjectis.remove(cartesObjectis.size()-1);
        }


    }

    public void jouer() {

        for (Joueur j : joueurs
        ) {
            Action action = j.jouer(placementsPossibles);
            if (action.getNomAction().equals("Parcelle")) {
                this.parcellesPlacees.add(new Parcelle((Position) action.getPosition()));
                System.out.println("Un joueur vient de placer une parcelle adjacente en " + action.getPosition());
                ObjectifParcelle o= (ObjectifParcelle) j.getCartesObjectifs().get(0);
                if(o.estValide(parcellesPlacees)){
                    j.addScore(o.getPoints());
                    System.out.println("L'objectif "+o.getNom()+" est validé");
                    System.out.println(j.getNom()+" a gagné avec un score de" + j.getScore());
                    break;
                }


            }

        }

    }


    public static void main (String[] args){
        Joueur joueur1=new Joueur(1.85,"Wassim");
        Joueur joueur2=new Joueur(1.6,"Brahim");
        Jeu jeu=new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();


    }





}

