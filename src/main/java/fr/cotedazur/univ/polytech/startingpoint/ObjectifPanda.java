package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectifPanda extends Objectif{
    static List<ObjectifPanda>objectifPandas=new ArrayList<>(Arrays.asList(
            new ObjectifPanda("MANGB",2,false,"",Arrays.asList(new Bambou(1)))
    ));
    public List<Bambou> getBambous() {
        return bambous;
    }

    private List<Bambou>bambous;
    public ObjectifPanda(String nom, int points, boolean statut, String description,List<Bambou>bambous) {
        super(nom, points, statut, description);
        this.bambous=new ArrayList<>(bambous);
    }

    @Override
    public boolean estValide(List<Parcelle> parcelles,Joueur joueur) {
        List<Bambou>joueurBambous=joueur.getPlateau().getBambous();
        if(joueurBambous.containsAll(this.bambous)) return true;
        return false;
    }

    @Override
    public ObjectifVerifier verifierValider(List<Parcelle> parcelles) {
        return null;
    }




}
