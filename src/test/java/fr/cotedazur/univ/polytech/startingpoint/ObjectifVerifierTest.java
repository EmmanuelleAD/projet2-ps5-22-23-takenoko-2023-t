package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifVerifierTest {

    @Test
    void isManquant() {
        ObjectifVerifier objectifVerifier = new ObjectifVerifier();
        assertEquals(false, objectifVerifier.isManquant());
    }

    @Test
    void getParcellesManquant() {
        ObjectifVerifier objectifVerifier = new ObjectifVerifier();
        assertEquals(0, objectifVerifier.getParcellesManquant().size());
    }

    @Test
    void setIsManquant() {
        ObjectifVerifier objectifVerifier = new ObjectifVerifier();
        objectifVerifier.setIsManquant(true);
        assertEquals(true, objectifVerifier.isManquant());

        objectifVerifier.setIsManquant(false);
        assertEquals(false, objectifVerifier.isManquant());

    }
}