package fr.cotedazur.univ.polytech.startingpoint;

public enum PersonnageName {

    Panda("Panda"),
    Jardinier("Jardinier");

    private final String name;

    PersonnageName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}