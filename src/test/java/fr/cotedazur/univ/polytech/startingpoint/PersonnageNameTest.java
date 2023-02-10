package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageNameTest {

    @Test
    void getName() {
        PersonnageName personnageName = PersonnageName.JARDINIER;
        assertEquals("JARDINIER", personnageName.getName());
    }
}