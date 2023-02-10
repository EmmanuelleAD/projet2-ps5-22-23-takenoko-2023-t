package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifVerifierParcelleTest {

    @Test
    public void testAjoutManquants() {
        ObjectifVerifierParcelle verifierParcelle = new ObjectifVerifierParcelle();
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(1, 2));
        positions.add(new Position(3, 4));
        verifierParcelle.ajoutManquants(positions);
        List<List<Position>> parcellesManquant = verifierParcelle.getParcellesManquant();
        assertEquals(1, parcellesManquant.size());
        assertEquals(2, parcellesManquant.get(0).size());
        assertEquals(new Position(1, 2), parcellesManquant.get(0).get(0));
        assertEquals(new Position(3, 4), parcellesManquant.get(0).get(1));
    }

    @Test
    public void testGetMoinsManquants() {
        ObjectifVerifierParcelle verifierParcelle = new ObjectifVerifierParcelle();
        List<Position> positions1 = new ArrayList<>();
        positions1.add(new Position(1, 2));
        positions1.add(new Position(3, 4));
        verifierParcelle.ajoutManquants(positions1);
        List<Position> positions2 = new ArrayList<>();
        positions2.add(new Position(5, 6));
        positions2.add(new Position(7, 8));
        positions2.add(new Position(9, 10));
        verifierParcelle.ajoutManquants(positions2);
        List<Position> moinsManquants = verifierParcelle.getMoinsManquants();
        assertEquals(2, moinsManquants.size());
        assertEquals(new Position(1, 2), moinsManquants.get(0));
        assertEquals(new Position(3, 4), moinsManquants.get(1));
    }


    @Test
    public void testSupprimerManquantAvecEtang() {
        ObjectifVerifierParcelle verifier = new ObjectifVerifierParcelle();
        List<Position> positions1 = new ArrayList<>();
        positions1.add(new Position(1, 1));
        positions1.add(new Position(2, 2));
        List<Position> positions2 = new ArrayList<>();
        positions2.add(new Position(3, 3));
        positions2.add(Parcelle.etang.getPosition());
        verifier.ajoutManquants(positions1);
        verifier.ajoutManquants(positions2);
        assertEquals(1, verifier.getParcellesManquant().size());
        assertEquals(positions1, verifier.getParcellesManquant().get(0));
    }


}