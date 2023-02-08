package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public class Jardinier extends Personnage{

    public Jardinier() {
    this.position = new Position(0,0);
    this.nom = PersonnageName.JARDINIER;
    }

    @Override
    public PersonnageName getName() {
        return PersonnageName.JARDINIER;
    }


    @Override
    public Optional<Bambou> move(Parcelle parcelle, List<Parcelle>parcelles) {
        this.deplacer(parcelle,parcelles);
        pousserBambou(parcelle, parcelles);
        return parcelle.getBambou();
    }

    private  void pousserBambou(Parcelle parcelle, List<Parcelle> parcelles) {
        if(!parcelles.contains(parcelle)) return;
        if(!parcelle.equals(Parcelle.etang)) {

            if (parcelle.getBambou().isPresent()) {
                if (parcelle.getTaille() < 4) parcelle.ajouterUneSection();
            } else {
                parcelle.setBambou(new Bambou());
            }
        }
        for (Parcelle p : parcelle.parcelleAdjacentes()
             ) {
            if(parcelles.contains(p)&& p.estIrrigue()&&!p.equals(Parcelle.etang)) p.setBambou(new Bambou());
        }
    }


}
