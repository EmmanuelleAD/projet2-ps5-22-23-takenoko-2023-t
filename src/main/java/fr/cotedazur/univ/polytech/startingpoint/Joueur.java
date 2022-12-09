
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    public String nom;
    public Parcelle[] tabParcelle;
    ArrayList list = new ArrayList();

    public Joueur(String nom, Parcelle[] tabParcelle) {


        this.nom = nom;
        this.tabParcelle = tabParcelle;


    }

    public void addParcelle(Parcelle parcelle) {
        list.add(parcelle);
    }

    public String getNom() {
        return nom;
    }


    public Parcelle jouerParcelle(){
        Random rand = new Random();
        Double x = rand.nextDouble();
        Double y = rand.nextDouble();
        Position positionParcelle1 = new Position(x, y);
        Parcelle parcelle1 = new Parcelle(positionParcelle1);
        return parcelle1;
    }
}
