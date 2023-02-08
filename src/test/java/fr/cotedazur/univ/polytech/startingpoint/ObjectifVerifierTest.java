package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifVerifierTest {
    ObjectifParcelle ali3;
    ObjectifVerifier ovAli3=new ObjectifVerifierParcelle();
    Parcelle p11=new Parcelle(new Position(1,1));
    List<Parcelle> parcelles=new ArrayList<>();
    @BeforeEach
    void setUp(){
         ali3=ObjectifParcelle.objectifParcelles.get(0);
         parcelles.add(Parcelle.etang);

    }
    @Test
    void CasAli3AvecEtang(){
        ObjectifVerifierParcelle ovali3=ObjectifParcelle.verifierValiderAli3(parcelles);
        assertFalse(ovali3.isManquant);
        assertEquals(0,ovali3.parcellesManquant.size());
    }
    @Test
    void CasAli3AvecEtangAvec1SeuleParcelle(){
        parcelles.add(p11);
        ObjectifVerifierParcelle ovali3=ObjectifParcelle.verifierValiderAli3(parcelles);
        assertFalse(ovali3.isManquant);
        System.out.println(ovali3.parcellesManquant);
        assertEquals(2,ovali3.parcellesManquant.get(0).size());
    }


    @Test
    void isManquant() {
        ObjectifVerifier objectifVerifier = new ObjectifVerifierParcelle();
        assertEquals(false, objectifVerifier.isManquant());
    }

    @Test
    void getParcellesManquant() {
        ObjectifVerifierParcelle objectifVerifier = new ObjectifVerifierParcelle();
        assertEquals(0, objectifVerifier.getParcellesManquant().size());
    }

    @Test
    void setIsManquant() {
        ObjectifVerifierParcelle objectifVerifier = new ObjectifVerifierParcelle();
        objectifVerifier.setIsManquant(true);
        assertEquals(true, objectifVerifier.isManquant());

        objectifVerifier.setIsManquant(false);
        assertEquals(false, objectifVerifier.isManquant());

    }

}