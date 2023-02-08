package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ActionParcelleTest {

    @Test
    void getParcelle() throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        Position position = new Position(1, 1);
        ActionParcelle actionParcelle = new ActionParcelle(new Parcelle(position));
        assertEquals(new Parcelle(position), actionParcelle.getParcelle());
    }

    @Test
    void getDescription() throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        Position position = new Position(1, 1);
        ActionParcelle actionParcelle = new ActionParcelle(new Parcelle(position));
        String comment = " vient d'éffectuer une action Parcelle .Il a  placé une parcelle irriguée en " + position.toString();
        assertEquals(comment, actionParcelle.getDescription());
    }


    @Test
    public void testTraiter() throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        Parcelle parcelle = new Parcelle(new Position(0,0));
        ActionParcelle actionParcelle = new ActionParcelle(parcelle);
        assertTrue(actionParcelle.traiter(joueur1, jeu));
    }
}