package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    public ArrayList<Parcelle> listParcelle;
    public ArrayList<Parcelle> listParcelleAdjacente;

    public Jeu(Joueur joueur1, Joueur joueur2, ArrayList<Parcelle> listeParcelle){
        this.joueur1=joueur1;
        this.joueur2=joueur2;
        this.listParcelle=listeParcelle;
    }


    public ArrayList<Parcelle> getListParcelle() {
        return listParcelle;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void start_game() {

    }
    public void parcellePossible() {
        if (listParcelleAdjacente.isEmpty()) {
            Position positionInitiale = new Position(0, 0);
            listParcelleAdjacente.add(new Parcelle(positionInitiale));
        }
    }
}
