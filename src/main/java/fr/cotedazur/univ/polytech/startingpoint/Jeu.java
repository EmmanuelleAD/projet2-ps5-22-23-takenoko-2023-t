package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;
import java.util.logging.Logger;

public class Jeu {
    public final static Logger logger = Logger.getLogger(Jeu.class.getName());

    private final List<Joueur> joueurs;
    private final List<Parcelle> parcellesPlacees;


    private List<Position> placementsPossibles;
    private final List<Objectif> cartesObjectis;


    private final List<ObjectifParcelle> objectifsParcelles;
    private final List<ObjectifJardinier> objectifsJardinier;



    private final List<ObjectifPanda> objectifsPanda;
    private boolean egalite =false;
    public boolean getEgalite(){return egalite;}
    private Jardinier jardinier;



    private final  Panda panda;

    private static final int MAX_CARTES_OBJECTIFS = 46;

    private int nombreObjectifs;


    public Jeu(Joueur joueur1, Joueur joueur2) {
        joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis = new ArrayList<>();
        this.objectifsParcelles = new ArrayList<>();
        this.objectifsJardinier = new ArrayList<>();
        this.objectifsPanda=new ArrayList<>();
        this.panda=new Panda();
    }

    public Jeu(List<Joueur> joueurs) {
        this.joueurs = new ArrayList<>();
        this.joueurs.addAll(joueurs);
        this.parcellesPlacees = new ArrayList<>();
        this.placementsPossibles = new ArrayList<>();
        this.cartesObjectis = new ArrayList<>();
        this.objectifsParcelles = new ArrayList<>();
        this.objectifsJardinier = new ArrayList<>();
        this.objectifsPanda=new ArrayList<>();
        this.panda=new Panda();



    }
    public Panda getPanda() {
        return panda;
    }

    public List<Parcelle> getParcellesPlacees() {
        return parcellesPlacees;
    }

    public List<Position> getPlacementsPossibles() {
        return placementsPossibles;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNombreObjectifs() {
        return nombreObjectifs;
    }

    public void setPlacementsPossibles(List<Position> placementsPossibles) {
        this.placementsPossibles = placementsPossibles;
    }

    public List<ObjectifParcelle> getObjectifsParcelles() {
        return objectifsParcelles;
    }

    public List<ObjectifJardinier> getObjectifsJardinier() {
        return objectifsJardinier;
    }
    public Jardinier getJardinier() {
        return jardinier;
    }
    public List<ObjectifPanda> getObjectifsPanda() {
        return objectifsPanda;
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
        this.jardinier = new Jardinier();
        Parcelle etang = new Parcelle(new Position(0, 0));
        parcellesPlacees.add(etang);
        placementsPossibles = Parcelle.positionsPossibleEnTenantCompteDeCellesPlacees(this.parcellesPlacees, placementsPossibles);
        Collections.sort(joueurs, Joueur.tailleComparator.reversed());

        for (int i = 0; i < 4; i++) {

            objectifsParcelles.addAll(ObjectifParcelle.objectifParcelles);
            Collections.shuffle(objectifsParcelles);
            objectifsJardinier.addAll(ObjectifJardinier.objectifsJardinier);
            Collections.shuffle(objectifsJardinier);
            objectifsPanda.addAll(ObjectifPanda.objectifPandas);
            Collections.shuffle(objectifsPanda);
        }
        for (Joueur joueur : joueurs
        ) {
            joueur.getCartesObjectifs().add(objectifsParcelles.get(objectifsParcelles.size() - 1)); //donner une carte de chaque catégorie
            objectifsParcelles.remove(objectifsParcelles.size() - 1);
            joueur.getCartesObjectifs().add(objectifsJardinier.get(objectifsJardinier.size() - 1));
            objectifsJardinier.remove(objectifsJardinier.size() - 1);
            joueur.getCartesObjectifs().add(objectifsPanda.get(objectifsPanda.size() - 1));
            objectifsPanda.remove(objectifsPanda.size() - 1);
        }
    }

    public void jouerUnTour(List<Joueur> joueurs) {



        for (Joueur j : joueurs) {
            Action action = j.jouer(this);
            if (nombreObjectifs == -2) {

                break;
            }

            List<Objectif> aSupp = new ArrayList<>();
            for (Objectif o : j.getCartesObjectifs()
            ) {

                if (o.estValide(parcellesPlacees, j)) {
                    j.addScore(o.getPoints());
                    logger.info("L'objectif " + o.getDescription() + " de " + o.getPoints() + " points est validé");
                    logger.info("Le score de " + j.getNom() + " est " + j.getScore());
                    nombreObjectifs--;
                    aSupp.add(o);
                }

            }
            j.getCartesObjectifs().removeAll(aSupp);

            if (nombreObjectifs == 0) {
                nombreObjectifs--;// to be sure that this condition won't be executed twice
                j.addScore(2);
                Joueur joueurDernierTour = j;
                logger.info("Le joueur " + j.getNom() + " a declenché le dernier tour et remporte le bonus de 2 points");
                List<Joueur> joueursSansGagnant = new ArrayList(joueurs);
                joueursSansGagnant.remove(j);
                jouerUnTour(joueursSansGagnant);
            }

        }
    }


    public List<Joueur> getGagnant() {

        Collections.sort(joueurs, Joueur.scoreComparator.reversed());
        List<Joueur> joueurGagnant = new ArrayList<>();
        int maxValeur = joueurs.get(0).getScore();
        for (Joueur joueur : joueurs) {
            if (maxValeur == joueur.getScore()) {
                joueurGagnant.add(joueur);
            }
        }
        return joueurGagnant;
    }



    public void jouer() {
        while (nombreObjectifs > 0) {
            jouerUnTour(joueurs);
        }
        for(Joueur joueur:joueurs){
            joueur.ajoutScoreMoyen(joueur.getScore());
        }

        List<Joueur> joueurGagnant = getGagnant();
        if (joueurGagnant.size() == 1) {
            Joueur joueur = joueurGagnant.get(0);
            joueur.ajoutPartieGagnees(1);
            logger.info(joueur.getNom() + " a gagné avec un score de " + joueur.getScore());
        } else {
            logger.info("Égalité! les joueurs suivants ont gagnés :");
            egalite =true;
            for (Joueur joueur : joueurGagnant) {
                joueur.ajoutPartieNulles(1);
                logger.info(joueur.getNom() + " a gagné avec un score de " + joueur.getScore());
            }
        }


    }


    public Joueur getJoueur1() {
        return joueurs.get(0);
    }


    public Joueur getJoueur2() {
        return joueurs.get(1);
    }
}

