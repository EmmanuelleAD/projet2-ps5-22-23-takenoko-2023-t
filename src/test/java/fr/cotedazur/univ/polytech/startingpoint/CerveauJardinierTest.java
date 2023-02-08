package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CerveauJardinierTest {

    @Test
    void tailleBambooParcelle() {
        Joueur joueur = new Joueur(1.5,"brahim");
        CerveauJardinier cerveauJardinier = new CerveauJardinier(joueur);
        Bambou bambou = new Bambou(3);
        Parcelle parcelle = new Parcelle(new Position(1,1));
        parcelle.setBambou(bambou);

        int expectedTaille = 3;
        int actualTaille = cerveauJardinier.tailleBambooParcelle(parcelle);

        assertEquals(expectedTaille, actualTaille);

    }



}