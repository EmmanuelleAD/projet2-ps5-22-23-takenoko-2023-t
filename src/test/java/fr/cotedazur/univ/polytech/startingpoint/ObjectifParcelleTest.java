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
    ObjectifParcelle objectifAli3;
    ObjectifParcelle objectifPARC;
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

        objectifAli3=new ObjectifParcelle("ALI3",2,false,"3 Parcelles alignées");
        objectifPARC=new ObjectifParcelle("PARC",3,false,"3 Parcelles en C");
        listPar1=Arrays.asList(p00,p01,p12);
        listPar2=Arrays.asList(p00,p01,p02);
        listPar3=Arrays.asList(p00,p01,p11);
        listPar4=Arrays.asList(p00,p01,p11,p02);

    }
    @Test
    void testverifierValiderALI3(){

        assertTrue(objectifAli3.estValide(listPar1));
        listPar1=Arrays.asList(p10,p01,p02);
        assertTrue(objectifAli3.estValide(listPar1));
        listPar1=Arrays.asList(p11,p12,p03);
        assertTrue(objectifAli3.estValide(listPar1));
        listPar1=Arrays.asList(p01,p12,p13);
        assertTrue(objectifAli3.estValide(listPar1));
        assertFalse(objectifAli3.estValide(Arrays.asList(p01)));
    }
    @Test
    void testverifierValiderPAR2(){
        assertFalse(objectifPARC.estValide(listPar1));
        assertTrue(objectifPARC.estValide(listPar2));
        listPar2=Arrays.asList(p11,p02,p13);
        assertTrue(objectifPARC.estValide(listPar2));

    }


}