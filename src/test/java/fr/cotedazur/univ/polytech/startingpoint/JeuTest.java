package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.ArrayList;

public class JeuTest {
    @Test
    void testerJeu(){
        Joueur joueur1=new Joueur();
        Joueur joueur2=new Joueur();
        Jeu jeu=new Jeu(joueur1, joueur2, new ArrayList<Parcelle>());
        jeu.start_game();
    }
}
