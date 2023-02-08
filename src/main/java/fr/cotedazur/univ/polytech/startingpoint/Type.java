package fr.cotedazur.univ.polytech.startingpoint;

public enum Type {
    TypeJardinier("Jardinier"),
    TypeParcelle("Parcelle"),
    TypePiocher("Piocher"),
    TypePanda("Panda"),
    TypePremierTour("Premier");

    public String getNomType() {
        return nomType;
    }

    private String nomType;

    Type(String nomType) {
        this.nomType = nomType;
    }

}
