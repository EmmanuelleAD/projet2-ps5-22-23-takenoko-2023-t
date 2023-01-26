package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifParcelleTest {
    Parcelle p00;
    Parcelle p01;
    Parcelle p02;
    Parcelle p03;
    Parcelle p10;
    Parcelle p11;
    Parcelle p12;
    Parcelle p13;
    Parcelle p20;
    Parcelle p21;
    Parcelle p22;
    ObjectifParcelle objectifAli3;
    ObjectifParcelle objectifPARC;
    ObjectifParcelle objectifGRP3;
    ObjectifParcelle objectifGRP4;
    List<Parcelle> listPar1;
    List<Parcelle> listPar2;
    List<Parcelle> listPar3;
    List<Parcelle> listPar4;

    @BeforeEach public void setUp(){
        p00=new Parcelle(new Position(0,0));
        p01=new Parcelle(new Position(0,1));
        p02=new Parcelle(new Position(0,2));
        p12=new Parcelle(new Position(1,2));
        p11=new Parcelle(new Position(1,1));
        p10=new Parcelle(new Position(1,0));
        p03=new Parcelle(new Position(0,3));
        p13=new Parcelle(new Position(1,3));
        p21=new Parcelle(new Position(2,1));
        p22=new Parcelle(new Position(2,2));
        p20=new Parcelle(new Position(2,0));
        objectifGRP3=new ObjectifParcelle("GRP3",3,false,"3 Parcelles groupées");
        objectifGRP4=new ObjectifParcelle("GRP4",3,false,"4 Parcelles groupées");
        objectifAli3=new ObjectifParcelle("ALI3",2,false,"3 Parcelles alignées");
        objectifPARC=new ObjectifParcelle("PARC",3,false,"3 Parcelles en C");
        listPar1=Arrays.asList(p10,p21,p22);
        listPar2=Arrays.asList(p10,p11,p12);
        listPar3=Arrays.asList(p10,p11,p21);
        listPar4=Arrays.asList(p10,p11,p21,p12);

    }
//    @Test
//    void testverifierValiderALI3(){
//
//        assertTrue(objectifAli3.estValide(listPar1));// y pair sens droit
//        listPar1=Arrays.asList(p01,p02,p13);
//        assertTrue(objectifAli3.estValide(listPar1));// y impair sens droit
//        listPar1=Arrays.asList(p10,p11,p02);
//        assertTrue(objectifAli3.estValide(listPar1)); // y pair sens gauche
//        listPar1=Arrays.asList(p11,p02,p03);
//        assertTrue(objectifAli3.estValide(listPar1));  // y impair sens gauche
//        assertFalse(objectifAli3.estValide(Arrays.asList(p01)));
//    }
    @Test
    void testverifierValiderPARC(){
        assertFalse(objectifPARC.estValide(listPar1));
        assertTrue(objectifPARC.estValide(listPar2)); //pair sens gauche
        listPar2=Arrays.asList(p11,p02,p13);
        assertTrue(objectifPARC.estValide(listPar2)); //impair sens gauche
        listPar2=Arrays.asList(p11,p12,p13);
        assertTrue(objectifPARC.estValide(listPar2)); //impair sens droit
        listPar2=Arrays.asList(p10,p21,p12);
        assertTrue(objectifPARC.estValide(listPar2)); //pair sens droit
        listPar2=Arrays.asList(p13,p02,p11);
        assertTrue(objectifPARC.estValide(listPar2)); //le sens importe peu

    }
    @Test
    void testverifierValiderGRP3(){
        assertFalse(objectifGRP3.estValide(listPar1));
        assertFalse(objectifGRP3.estValide(listPar2));
        assertTrue(objectifGRP3.estValide(listPar3)); //pair en bas
        listPar3=Arrays.asList(p11,p02,p12); //impair en bas
        assertTrue(objectifGRP3.estValide(listPar3));
        listPar3=Arrays.asList(p21,p10,p20); //impair en haut
        assertTrue(objectifGRP3.estValide(listPar3));
        listPar3=Arrays.asList(p12,p11,p21); //pair en haut
        assertTrue(objectifGRP3.estValide(listPar3));

    }
    @Test
    void testverifierValiderPAR4(){
        Objectif o=ObjectifParcelle.objectifParcelles.get(0);
        System.out.println(o.getType());
        assertFalse(objectifGRP4.estValide(listPar1));
        assertFalse(objectifGRP4.estValide(listPar2));
        assertFalse(objectifGRP4.estValide(listPar3));
        assertTrue(objectifGRP4.estValide(listPar4)); //pair
        listPar4=Arrays.asList(p11,p02,p12,p13); //impair
        assertTrue(objectifGRP4.estValide(listPar4));
        listPar4=Arrays.asList(p00,p01,p11,p02); //etang ne fait pas partie du motif
        assertFalse(objectifGRP4.estValide(listPar4));


    }


}