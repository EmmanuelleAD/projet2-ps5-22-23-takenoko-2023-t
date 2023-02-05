package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public abstract class Personnage {
    protected PersonnageName nom;

    protected Position position;

    public Personnage() {
    }


    public abstract PersonnageName getName();

    public abstract Optional<Bambou> move(Parcelle parcelle, List<Parcelle> parcelles);
    public void deplacer(Parcelle parcelle,List<Parcelle>parcelles){
        if(parcelles.contains(parcelle)) this.position=parcelle.getPosition();

    }


    public Position getPosition() {
        return position;
    }
}