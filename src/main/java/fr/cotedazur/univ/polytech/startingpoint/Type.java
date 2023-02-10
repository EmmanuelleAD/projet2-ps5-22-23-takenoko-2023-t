package fr.cotedazur.univ.polytech.startingpoint;

public enum Type {
    TYPE_JARDINIER("JARDINIER"),
    TYPE_PARCELLE("Parcelle"),
    TYPE_PIOCHER("Piocher"),
    TYPE_PANDA("PANDA"),
    TYPE_PREMIER_TOUR("Premier");

    public String getNomType() {
        return nomType;
    }

    private final String nomType;

    Type(String nomType) {
        this.nomType = nomType;
    }

}
