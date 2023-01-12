package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    private List<Joueur> joueurs;

    public List<Parcelle> getParcellesPlacees() {
        return parcellesPlacees;
    }

    public List<Position> getPlacementsPossibles() {
        return placementsPossibles;
    }

    private List<Parcelle> parcellesPlacees;
    private List<Position> placementsPossibles;
    private List<Objectif> cartesObjectis;
    private static final int MAX_CARTES_OBJECTIFS = 46;

    public int getNombreObjectifs() {
        return nombreObjectifs;
    }

    private int nombreObjectifs;


    public Jeu(Joueur joueur1, Joueur joueur2) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis = new ArrayList<>();

    }
    public Jeu(Joueur joueur1, Joueur joueur2,Joueur joueur3) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        joueurs.add(joueur3);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis = new ArrayList<>();

    }
    public Jeu(Joueur joueur1, Joueur joueur2,Joueur joueur3,Joueur joueur4) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        joueurs.add(joueur3);
        joueurs.add(joueur4);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis = new ArrayList<>();

    }

    public void initialisation() {
        switch (joueurs.size()) {
            case 2:
                nombreObjectifs = 9;
                break;
            case 3:
                nombreObjectifs = 8;
                break;
            case 4:
                nombreObjectifs = 7;
                break;
        }
        Parcelle etang = new Parcelle(new Position(0, 0));
        parcellesPlacees.add(etang);
        placementsPossibles = Parcelle.positionsPossibleEnTenantCompteDeCellesPlacees(this.parcellesPlacees, placementsPossibles);
        Collections.sort(joueurs, Joueur.tailleComparator.reversed());
        for (int i = 0; i < MAX_CARTES_OBJECTIFS / 2; i++) {
            cartesObjectis.add(ObjectifParcelle.objectifParcelles.get(0));
            cartesObjectis.add(ObjectifParcelle.objectifParcelles.get(1));
        }
        for (Joueur joueur : joueurs
        ) {
            joueur.getCartesObjectifs().add(cartesObjectis.get(cartesObjectis.size() - 1));
            cartesObjectis.remove(cartesObjectis.size() - 1);
        }
    }

    public void jouerUnTour(List<Joueur> joueurs) {


        for (Joueur j : joueurs) {
            Action action = j.jouer(placementsPossibles);
            if (action.getNomAction().equals("Parcelle")) {
                if (nombreObjectifs==-2){
                    break;
                }
                traiterActionParcelle(j, action);

            }
            for (Objectif o : j.getCartesObjectifs()
            ) {
                if (o.estValide(parcellesPlacees)) {
                    j.addScore(o.getPoints());
                    System.out.println("L'objectif " + o.getDescription() + " de " + o.getPoints() + " points est validé");
                    System.out.println("Le score de " + j.getNom() + " est " + j.getScore());
                    nombreObjectifs--;
                }

            }
            if (nombreObjectifs == 0) {
                nombreObjectifs--;// to be sure that this condition won't be executed twice
                j.addScore(2);
                Joueur joueurDernierTour = j;
                System.out.println("Le joueur " + j.getNom() + " a declenché le dernier tour et remporte le bonus de 2 points");
                List<Joueur> joueursSansGagnant = new ArrayList(joueurs);
                joueursSansGagnant.remove(j);
                jouerUnTour(joueursSansGagnant);
            }

        }
    }

    public List<Joueur> getGagnant() {

        Collections.sort(joueurs, Joueur.scoreComparator.reversed());
        List<Joueur> joueurGagnant=new ArrayList<>();
        int maxValeur=joueurs.get(0).getScore();
        for (Joueur joueur: joueurs){
            if (maxValeur==joueur.getScore()){
                joueurGagnant.add(joueur);
            }
        }
        return joueurGagnant;
    }

    void traiterActionParcelle(Joueur j, Action action) {
        ActionParcelle ap = (ActionParcelle) action;
        Parcelle nouvelleParcelle = ap.getParcelle();
        this.parcellesPlacees.add(nouvelleParcelle);
        placementsPossibles = Parcelle.positionsPossible(this.parcellesPlacees, placementsPossibles);
        System.out.println(j.getNom() + ap.getDescription());

    }


    public void jouer() {
        while (nombreObjectifs > 0) {
            jouerUnTour(joueurs);
        }
<<<<<<< HEAD
        Joueur joueur = getGagnant();
        System.out.println(joueur.getNom() + " a gagné avec un score de " + joueur.getScore());

    }


    public static void main(String[] args) {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
=======
        List<Joueur> joueurGagnant=getGagnant();
        if (joueurGagnant.size()==1){
            Joueur joueur = joueurGagnant.get(0);
            System.out.println(joueur.getNom() + " a gagné avec un score de " + joueur.getScore());
        } else {
            System.out.println("Égalité! les joueurs suivants ont gagnés :");
            for (Joueur joueur: joueurGagnant){
                System.out.println(joueur.getNom() + " a gagné avec un score de " + joueur.getScore());
            }
        }
>>>>>>> cdb8700df7b28b421e9345d62ccdffe921a91627


    }


<<<<<<< HEAD
}
=======



}

>>>>>>> cdb8700df7b28b421e9345d62ccdffe921a91627
