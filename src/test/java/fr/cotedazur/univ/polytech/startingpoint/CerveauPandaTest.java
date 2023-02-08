package fr.cotedazur.univ.polytech.startingpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CerveauPandaTest {
    Parcelle p11=new Parcelle(new Position(1,1));
    Joueur joueur=new Joueur(1.7,"Mohamed");
    Joueur joueuse=new Joueur(1.6,"Emmanuelle");
    CerveauPanda cerveauPanda=new CerveauPanda(joueuse);
    Jeu jeu=new Jeu(joueuse,joueur);

    public CerveauPandaTest() throws NoSuchAlgorithmException {
    }

    @BeforeEach
    void setUp(){
        joueuse.setCerveau(new CerveauPanda(joueuse));
        jeu.initialisation();
    }
    @Test
    void testCasNormal(){
        jeu.getParcellesPlacees().add(p11);
      Action act=  cerveauPanda.decider(jeu);
      assertEquals(Type.TYPE_PANDA.getNomType(),act.getNomAction());


    }
    @Test
    void testCasDefaut(){
        jeu.getParcellesPlacees().add(p11);
        p11.setBambou(new Bambou(0));
        Action act=  cerveauPanda.decider(jeu);
        assertEquals(Type.TYPE_JARDINIER.getNomType(),act.getNomAction());


    }
    @Test
    void testSansCartes(){
        joueuse.setCartesObjectifs(new ArrayList<>());
        jeu.getParcellesPlacees().add(p11);
        Action act=  cerveauPanda.decider(jeu);
        assertEquals(Type.TYPE_PIOCHER.getNomType(),act.getNomAction());


    }
}
