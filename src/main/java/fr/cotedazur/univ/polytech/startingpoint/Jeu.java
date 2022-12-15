package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private List<Joueur> joueurs;
    public List<Parcelle> parcellesPlacees;
    public List<Position> placementsPossibles;


    public Jeu(Joueur joueur1, Joueur joueur2) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
    }

    public void initialisation() {
        Parcelle etang = new Parcelle(new Position(0, 0));
        parcellesPlacees.add(etang);
        Collections.sort(joueurs, Joueur.tailleComparator);

    }

    public void jouer() {

        for (Joueur j : joueurs
        ) {
            Action action = j.jouer();
            if (action.getNomAction().equals("Parcelle")) {
                this.parcellesPlacees.add(new Parcelle((Position) action.getPosition()));
                System.out.println("Un joueur vient de placer une parcelle en " + action.getPosition());
                System.out.println("Il a gagné ");
                break;
            }

        }

    }


    public static void main (String[] args){
        Joueur joueur1=new Joueur(1.85);
        Joueur joueur2=new Joueur(1.6);
        Jeu jeu=new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();


    }





}

