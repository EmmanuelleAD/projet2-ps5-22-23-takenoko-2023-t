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
            List action = j.jouer();
            if (action.get(0).equals("Parcelle")) {
                this.parcellesPlacees.add(new Parcelle((Position) action.get(1)));
                System.out.println("Un joueur vient de placer une parcelle en " + action.get(1));
                System.out.println("Il a gagné ");
                break;
            }

        }


    }


    /** public void parcellePossible() {
     if (listParcelleAdjacente.isEmpty()) {
     Position positionInitiale = new Position(0, 0);
     listParcelleAdjacente.add(new Parcelle(positionInitiale));
     }
     }**/
}
