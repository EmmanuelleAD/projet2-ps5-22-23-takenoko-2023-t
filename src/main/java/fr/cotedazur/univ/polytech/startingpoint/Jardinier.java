package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public class Jardinier extends Personnage{

    public Jardinier() {
    this.position = new Position(0,0);
    this.nom = PersonnageName.Jardinier;
    }

    @Override
    public PersonnageName getName() {
        return PersonnageName.Jardinier;
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

    public Optional<Bambou> moveStraight(Parcelle parcelle, List<Parcelle>parcelles, int x, int y) {
        this.position = parcelle.getPosition();
        if (parcelle.getBambou().isPresent()){
            parcelle.getBambou().orElse(new Bambou()).ajouterUneSection();
        }else{
            parcelle.setBambou(new Bambou());
        }

        int newX = parcelle.getPosition().getX() + x;
        int newY = parcelle.getPosition().getY() + y;
        Parcelle newParcelle = parcelles.stream().filter(p -> p.getPosition().getX() == newX && p.getPosition().getY() == newY).findFirst().orElse(null);
        if(newParcelle != null && newParcelle.estIrrigue() && !newParcelle.equals(Parcelle.etang)) newParcelle.setBambou(new Bambou());

        return parcelle.getBambou();
    }
}
