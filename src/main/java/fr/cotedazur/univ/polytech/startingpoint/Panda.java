package fr.cotedazur.univ.polytech.startingpoint;

import java.util.List;
import java.util.Optional;

public class Panda extends Personnage{


    public Panda() {
        this.nom=PersonnageName.Panda;
        this.position=Parcelle.etang.getPosition();
    }



    @Override
    public PersonnageName getName() {
        return nom;
    }

    @Override
    public Optional<Bambou> move(Parcelle parcelle, List<Parcelle> parcelles) {
        this.deplacer(parcelle,parcelles);
       return this.mangerBambou(parcelle,parcelles);

    }
     Optional<Bambou> mangerBambou(Parcelle parcelle,List<Parcelle>parcelles){
        if(parcelles.contains(parcelle)) {
            if (parcelle.getTaille() > 0) {
                parcelle.enleverUneSection();
                return Optional.ofNullable(new Bambou(1));

            }
            }
        return Optional.empty();
        }
        /*public  void deplacerDroit(Parcelle parcelle, List<Parcelle> parcelles){
            if(!isStraightMovement(oldPosition, newPosition)) {
                throw new IllegalArgumentException("Panda can only move in a straight line.");
            }
        }

*/

    



}
