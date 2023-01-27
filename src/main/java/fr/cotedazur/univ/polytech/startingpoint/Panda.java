package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public class Panda extends Personnage{


    public Panda(Parcelle parcelle) {
        this.position = parcelle.getPosition();
    }

    @Override
    public Bambou move(Parcelle parcelle) {
        return null;
    }

    @Override
    public PersonnageName getName() {
        return PersonnageName.Panda;
    }

    @Override
    public Optional<Bambou> move(Parcelle parcelle, List<Parcelle> parcelles) {
        return Optional.empty();
    }

}
