package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public void ajouterBambou(Bambou bambou){
        this.bambous.add(bambou);
    }
    public List<Bambou> getBambous() {
        return bambous;
    }

    private List<Bambou>bambous;

    public Plateau() {
        this.bambous=new ArrayList<>();
    }

}
