package fr.cotedazur.univ.polytech.startingpoint;

public class Jardinier extends Personnage{

    public Jardinier() {
    this.position = new Position(0,0);
    this.nom = PersonnageName.Jardinier;
    }

    @Override
    public Bambou move(Parcelle parcelle) {
        this.position = parcelle.getPosition();
        if (parcelle.getBambou().isPresent()){
            parcelle.getBambou().orElse(new Bambou()).setTaille();
        }else{
            parcelle.setBambou(new Bambou());
        }

        return null;
    }

}
