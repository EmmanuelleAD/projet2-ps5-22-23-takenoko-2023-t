package fr.cotedazur.univ.polytech.startingpoint;

import java.util.Optional;

public abstract class Personnage{

    protected Position position;

    public PersonnageName getName() {
        return PersonnageName.Jardinier;
    }

    public abstract Optional<Bambou> move(Parcelle parcelle);

    public PersonnageName getNom() {
        return nom;
    }

    protected PersonnageName nom;



    public Position getPosition() {
        return position;
    }
}