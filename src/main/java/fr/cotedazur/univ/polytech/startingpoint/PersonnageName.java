package fr.cotedazur.univ.polytech.startingpoint;

public enum PersonnageName {

    PANDA("PANDA"),
    JARDINIER("JARDINIER");

    private final String name;

    PersonnageName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}