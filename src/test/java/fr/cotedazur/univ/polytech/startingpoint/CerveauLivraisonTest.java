package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CerveauLivraisonTest {

    Parcelle p11=new Parcelle(new Position(1,1));
    Joueur joueur=new Joueur(1.7,"Mohamed");
    Joueur joueurSaboteur =new Joueur(1.6,"Emmanuelle");

    CerveauLivraison cerveauLivraison=new CerveauLivraison(joueurSaboteur);

    Jeu jeu=new Jeu(joueurSaboteur,joueur);
    @BeforeEach
    void setUp(){
        joueurSaboteur.setCerveau(new CerveauLivraison(joueurSaboteur));
        jeu.initialisation();
    }


}