package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    public ArrayList<Parcelle> listParcelle;

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
        Random rand = new Random();
        Double x = rand.nextDouble();
        Double y = rand.nextDouble();
        Position positionParcelle1 = new Position(x, y);
        Parcelle parcelle1 = new Parcelle(positionParcelle1);
        int i;
        for (i = 0; i < listParcelle.size(); i++) {
            if (listParcelle.get(i).isAdjacent(parcelle1)) {
                break
            }
        }
        String check = (i % 2 == 0) ? "joueur1" : "joueur2";
        System.out.println("le gagnant est :"+check);
    }
}
