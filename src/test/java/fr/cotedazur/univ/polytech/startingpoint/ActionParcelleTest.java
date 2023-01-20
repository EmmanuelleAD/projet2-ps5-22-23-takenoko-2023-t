package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionParcelleTest {

    @Test
    void getParcelle() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        Position position = new Position(1, 1);
        ActionParcelle actionParcelle = new ActionParcelle(new Parcelle(position));
        assertEquals(position, actionParcelle.getParcelle().getPosition());
    }

    @Test
    void getDescription() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();
        Position position = new Position(1, 1);
        ActionParcelle actionParcelle = new ActionParcelle(new Parcelle(position));
        String comment = " vient d'éffectuer une action Parcelle .Il a  placé une parcelle irriguée en " + position.toString();
        assertEquals(comment, actionParcelle.getDescription());
    }
}