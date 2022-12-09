package fr.cotedazur.univ.polytech.startingpoint;

import java.lang.reflect.Array;
import java.util.*;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    public ArrayList<Parcelle> listParcelle;
    public ArrayList<Parcelle> listParcelleAdjacente;
    public Parcelle parcelleInitiale=new Parcelle(new Position(0,0));

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
        Parcelle parcelle1=joueur1.jouerParcelle();
        Parcelle parcelle2=joueur2.jouerParcelle();
        while (!(parcelle1.isAdjacent(parcelleInitiale) && parcelle2.isAdjacent(parcelleInitiale))){
            parcelle1=joueur1.jouerParcelle();
            System.out.println("le joueur 1 a placé une parcelle en ( "+parcelle1.getPosition().getX()+" , "+parcelle1.getPosition().getY()+" )");
            parcelle2=joueur2.jouerParcelle();
            System.out.println("le joueur 2 a placé une parcelle en ( "+parcelle2.getPosition().getX()+" , "+parcelle2.getPosition().getY()+" )");
            if (parcelle1.isAdjacent(parcelleInitiale)){
                System.out.println("Joueur 1 a gagné");
                break;
            } else if(parcelle2.isAdjacent(parcelleInitiale)){
                System.out.println("Joueur 2 a gagné");
                break;
            }
        }

    }
    public void parcellePossible() {
        if (listParcelleAdjacente.isEmpty()) {
            Position positionInitiale = new Position(0, 0);
            listParcelleAdjacente.add(new Parcelle(positionInitiale));
        }
    }
}
