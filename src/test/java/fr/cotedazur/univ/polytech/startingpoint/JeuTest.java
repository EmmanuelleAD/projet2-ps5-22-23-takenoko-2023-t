package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JeuTest {
    private Joueur wassim=new Joueur(1.7,"Wassim");
    private Joueur brahim=new Joueur(1.8,"Brahim");

    private Joueur mohamed=new Joueur(1.78,"Mohamed");

    private Joueur emmanuelle=new Joueur(1.6,"Emmanuelle");
    private  Parcelle etang=new Parcelle(new Position(0,0));
    @Nested
    class TestJeuDe2Joueurs{
        @Test
        void testInitialisation(){
            Jeu jeu=new Jeu(wassim,brahim);
            jeu.initialisation();
            assertEquals(jeu.getNombreObjectifs(),9);
            assertEquals(jeu.getParcellesPlacees().size(),1);
            assertTrue(jeu.getParcellesPlacees().contains(etang));
            assertEquals(brahim,jeu.getJoueurs().get(0)); //le joueur le plus grand commence
            assertEquals(6,jeu.getPlacementsPossibles().size()); //les placements possibles les seules adjacentes à etang
            for (Position p:etang.getPosition().positionsAdjacentes()
                 ) {
                jeu.getPlacementsPossibles().contains(p);
            }


        }

    }
    @Nested
    class JeuDe4Joueurs{
        @Test
        void testInitialisation(){
            List<Joueur> joueurs=Arrays.asList(wassim,brahim,emmanuelle,mohamed);
            Jeu jeu=new Jeu(joueurs);
            jeu.initialisation();
            assertEquals(jeu.getNombreObjectifs(),7);
            assertEquals(jeu.getParcellesPlacees().size(),1);
            assertTrue(jeu.getParcellesPlacees().contains(etang));
            assertEquals(brahim,jeu.getJoueurs().get(0)); //le joueur le plus grand commence
            assertEquals(6,jeu.getPlacementsPossibles().size()); //les placements possibles les seules adjacentes à etang
            for (Position p:etang.getPosition().positionsAdjacentes()
            ) {
                jeu.getPlacementsPossibles().contains(p);
            }
            jeu.jouer();


        }

    }
    @Nested
    class testPlacementsPossibles{

    }


}
