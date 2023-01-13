package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public class Jardinier extends Personnage{

    public Jardinier() {
    this.position = new Position(0,0);
    this.nom = PersonnageName.Jardinier;
    }

    @Override
    public Optional<Bambou> move(Parcelle parcelle, List<Parcelle>parcelles) {
        this.position = parcelle.getPosition();
        if (parcelle.getBambou().isPresent()){
            parcelle.getBambou().orElse(new Bambou()).setTaille();
        }else{
            parcelle.setBambou(new Bambou());
        }
        for (Parcelle p :parcelle.parcelleAdjacentes()
             ) {
            if(parcelles.contains(p)&& p.estIrrigue()&&!p.equals(Parcelle.etang)) p.setBambou(new Bambou());
        }

        return parcelle.getBambou();
    }

}
