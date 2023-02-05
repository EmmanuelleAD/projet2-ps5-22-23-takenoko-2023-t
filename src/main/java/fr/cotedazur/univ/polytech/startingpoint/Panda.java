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
        this.mangerBambou(parcelle,parcelles);

        return parcelle.getBambou();
    }
    private void mangerBambou(Parcelle parcelle,List<Parcelle>parcelles){
        if(parcelles.contains(parcelle)) {
            if (parcelle.getTaille() > 0) parcelle.enleverUneSection();
        }
    }

    public boolean isStraightMovement(Position oldPosition, Position newPosition) {
        int x1 = oldPosition.getX();
        int y1 = oldPosition.getY();
        int x2 = newPosition.getX();
        int y2 = newPosition.getY();

        // check if movement is horizontal
        if (y1 == y2) {
            return true;
        }
        // check if movement is vertical
        if (x1 == x2) {
            return true;
        }
        // check if movement is diagonal
        if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
            return true;
        }
        return false;
    }
    
    public Optional<Bambou> move(Parcelle parcelle, List<Parcelle> parcelles, String direction) {
        int x = this.position.getX();
        int y = this.position.getY();
        Position oldPosition = this.position;
        switch (direction) {
            case "up":
                y -= 1;
                break;
            case "down":
                y += 1;
                break;
            case "left":
                x -= 1;
                break;
            case "right":
                x += 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

        Position newPosition = new Position(x, y);
        // code to check if new position is valid
        if(!isStraightMovement(oldPosition, newPosition)) {
            throw new IllegalArgumentException("Panda can only move in a straight line.");
        }
        this.position = newPosition;
        return Optional.empty();
    }


}
