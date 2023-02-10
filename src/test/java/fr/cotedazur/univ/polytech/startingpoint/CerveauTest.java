package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CerveauTest {
    Joueur joueur1 = new Joueur(1.85, "Wassim");
    Joueur joueur2 = new Joueur(1.6, "Brahim");
    Jeu jeu = new Jeu(joueur1, joueur2);
    CerveauJardinier cerveauJardinierJoueur1 =new CerveauJardinier(joueur1);
    CerveauParcelle cerveauParcelleJoueur1 = new CerveauParcelle(joueur1);
    @BeforeEach void setUp(){
        jeu.initialisation();;
    }

    @Test
    void decider() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

        cerveauParcelleJoueur1.decider(jeu);
        assertEquals(3, cerveauParcelleJoueur1.decider(jeu).getNbreAction());

    }

    @Test
    void deciderReturnNull() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

       ;
        assertEquals(Type.TYPE_JARDINIER.getNomType(), cerveauParcelleJoueur1.decider(jeu).getNomAction());
       // assertEquals(new ActionParcelle(new Parcelle( jeu.getPlacementsPossibles().get(0))), cerveauParcelleJoueur1.decider(jeu));

    }


    @Test
    void testerCasSansCarte(){
        joueur1.setCartesObjectifs(new ArrayList<>());
        Action act= cerveauJardinierJoueur1.decider(jeu);
        List<ObjectifJardinier> op = jeu.getObjectifsJardinier();
        Objectif newObjectif = op.get(op.size()-1);
        assertEquals(new ActionPiocher(newObjectif),act);
    }

    @Test
    void testerCasObjectifJardinierB14(){
        List<Objectif> listObjectifs= new ArrayList<>();
        listObjectifs.add(ObjectifJardinier.objectifsJardinier.get(0));
        joueur1.setCartesObjectifs(listObjectifs);
        Parcelle parcelle = new Parcelle(new Position(1,0));
        jeu.getParcellesPlacees().add(parcelle);
        jeu.getParcellesPlacees().get(0).setBambou(new Bambou(3));
        Action act= cerveauJardinierJoueur1.decider(jeu);
        assertEquals(act,new ActionJardinier(jeu.getParcellesPlacees().get(0)));
    }

    @Test
    void testerCasObjectifJardinierB43(){
        List<Objectif> listObjectifs=new ArrayList<>();
        listObjectifs.add(ObjectifJardinier.objectifsJardinier.get(1));
        joueur1.setCartesObjectifs(listObjectifs);
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,0)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(0,1)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,1)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(2,0)));
        jeu.getParcellesPlacees().get(0).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(1).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(2).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(3).setBambou(new Bambou(2));
        Action act= cerveauJardinierJoueur1.decider(jeu);
        assertEquals(act,new ActionJardinier(jeu.getParcellesPlacees().get(3)));
    }

    @Test
    void testerCasObjectifJardinierNonaccompli(){
        List<Objectif> listObjectifs=new ArrayList<>();
        listObjectifs.add(ObjectifJardinier.objectifsJardinier.get(1));
        joueur1.setCartesObjectifs(listObjectifs);
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,0)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(0,1)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,1)));
        jeu.getParcellesPlacees().get(0).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(1).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(2).setBambou(new Bambou(3));
        Action act= cerveauJardinierJoueur1.decider(jeu);
        assertEquals(act.getNomAction(),Type.TYPE_JARDINIER.getNomType());
    }
    @Test
    void testerCasObjectifJardinierAccomplis(){
        List<Objectif> listObjectifs=new ArrayList<>();
        listObjectifs.add(ObjectifJardinier.objectifsJardinier.get(1));
        joueur1.setCartesObjectifs(listObjectifs);
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,0)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(0,1)));
        jeu.getParcellesPlacees().add(new Parcelle(new Position(1,1)));
        jeu.getParcellesPlacees().get(0).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(1).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(2).setBambou(new Bambou(3));
        jeu.getParcellesPlacees().get(3).setBambou(new Bambou(3));

        Action act= cerveauJardinierJoueur1.decider(jeu);
        assertEquals(act.getNomAction(),Type.TYPE_PARCELLE.getNomType());
    }
}
