package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Collection;
import java.util.List;

public abstract class Cerveau {
    public Joueur joueur;

    public Cerveau(Joueur joueur) {
        this.joueur=joueur;
    }
    public abstract Action decider(Jeu jeu);


    





}
