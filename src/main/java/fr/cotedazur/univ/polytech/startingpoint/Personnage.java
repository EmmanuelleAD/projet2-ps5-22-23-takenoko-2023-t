package fr.cotedazur.univ.polytech.startingpoint;

public abstract class Personnage{

    protected Position position;


    public abstract Bambou move(Parcelle parcelle);

    public abstract PersonnageName getName();



    public Position getPosition() {
        return position;
    }
}