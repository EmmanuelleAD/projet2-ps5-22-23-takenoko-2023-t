package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifVerifierPandaTest {

    @Test
    public void testGetBambouList() {
        ObjectifVerifierPanda verifierPanda = new ObjectifVerifierPanda();
        List<Bambou> bambous = new ArrayList<>();
        verifierPanda.setBambouList(bambous);
        assertEquals(bambous, verifierPanda.getBambouList());
    }

    @Test
    public void testSetBambouList() {
        ObjectifVerifierPanda verifierPanda = new ObjectifVerifierPanda();
        List<Bambou> bambous = new ArrayList<>();
        verifierPanda.setBambouList(bambous);
        assertEquals(bambous, verifierPanda.getBambouList());
    }

    @Test
    public void testObjectifVerifierPandaDefaultConstructor() {
        ObjectifVerifierPanda verifierPanda = new ObjectifVerifierPanda();
        assertNotNull(verifierPanda.getBambouList());
        assertTrue(verifierPanda.getBambouList().isEmpty());
    }

    @Test
    public void testObjectifVerifierPandaConstructorWithList() {
        List<Bambou> bambous = new ArrayList<>();
        ObjectifVerifierPanda verifierPanda = new ObjectifVerifierPanda(bambous);
        assertEquals(bambous, verifierPanda.getBambouList());
    }

    @Test
    public void testVerifierValider() {
        ObjectifVerifierPanda verifierPanda = new ObjectifVerifierPanda();
        List<Bambou>bambous=new ArrayList<>();
        ObjectifPanda objectifPanda = new ObjectifPanda("Panda", 5,false, "manger bambou",bambous);
        assertNull(verifierPanda.verifierValider(objectifPanda));
    }

}