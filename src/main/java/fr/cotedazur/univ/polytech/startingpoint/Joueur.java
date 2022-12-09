
package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;

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
}
