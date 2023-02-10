package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ObjectifJardinierTest {
    ObjectifJardinier b14= new ObjectifJardinier("B14",20,false,"",4,1);
    ObjectifJardinier b43=new ObjectifJardinier("B43",6,false,"",3,4);
    List<Parcelle> parcelles=new ArrayList<>();
    Parcelle p14=new Parcelle(new Position(1,1));
    Parcelle p21=new Parcelle(new Position(2,1));
    Parcelle p22=new Parcelle(new Position(2,2));
    Parcelle p32=new Parcelle(new Position(3,2));
    Parcelle p33=new Parcelle(new Position(3,3));

    @Test
   void testBambou1Taille4(){
        p14.setBambou(new Bambou(4));
        parcelles.add(p14);
        assertTrue(b14.estValide(parcelles));


    }
    @Test
    void testBambou4Taille3(){
        p21.setBambou(new Bambou(3));
        p22.setBambou(new Bambou(3));
        p32.setBambou(new Bambou(3));
        p33.setBambou(new Bambou(3));
        parcelles.add(p21);
        parcelles.add(p22);
        parcelles.add(p32);
        parcelles.add(p33);

        assertTrue(b43.estValide(parcelles));


    }
    @Test
    void testParcellesVides(){
        assertFalse(b14.estValide(parcelles));
        assertFalse(b43.estValide(parcelles));

    }
    @Test
    void parcellesInvalidesB14(){
        p21.setBambou(new Bambou(1));
        p22.setBambou(new Bambou(2));
        p32.setBambou(new Bambou(3));
        p33.setBambou(new Bambou(3));
        parcelles.add(p21);
        parcelles.add(p22);
        parcelles.add(p32);
        parcelles.add(p33);

        assertFalse(b14.estValide(parcelles));


    }
    @Test
    void parcellesInvalidesB43(){
        p21.setBambou(new Bambou(1));
        p22.setBambou(new Bambou(3));
        p32.setBambou(new Bambou(3));
        p33.setBambou(new Bambou(3));
        parcelles.add(p21);
        parcelles.add(p22);
        parcelles.add(p32);
        parcelles.add(p33);

        assertFalse(b43.estValide(parcelles));


    }

    @Test
    void getTaille() {
        assertEquals(4,b14.getTaille());
        assertEquals(3,b43.getTaille());
    }



    @Test
    void testEquals() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"",4,1);
        ObjectifJardinier b43bis=new ObjectifJardinier("B43",6,false,"",3,4);
        assertEquals(b14,b14bis);
        assertEquals(b43,b43bis);
    }

    @Test
    void estValide() {
        p14.setBambou(new Bambou(4));
        parcelles.add(p14);
        assertTrue(b14.estValide(parcelles));
        p21.setBambou(new Bambou(3));
        p22.setBambou(new Bambou(3));
        p32.setBambou(new Bambou(3));
        p33.setBambou(new Bambou(3));
        parcelles.add(p21);
        parcelles.add(p22);
        parcelles.add(p32);
        parcelles.add(p33);

        assertTrue(b43.estValide(parcelles));
    }


    @Test
    void getTypeTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"",4,1);
        assertEquals("JARDINIER",b14bis.getType());

        ObjectifJardinier b15bis= new ObjectifJardinier("B15",20,false,"",4,1);
        assertEquals("JARDINIER",b14bis.getType());
    }


    @Test
    void isStatutTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"",4,1);
        assertFalse(b14bis.isStatut());


        ObjectifJardinier b15= new ObjectifJardinier("B15",30,true,"",5,2);
        assertTrue(b15.isStatut());

    }


    @Test
    void getDecriptionTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"Objectif B14",4,1);
        assertEquals("Objectif B14",b14bis.getDescription());


        ObjectifJardinier b15= new ObjectifJardinier("B15",30,true,"Objectif B15",5,2);
        assertEquals("Objectif B15",b15.getDescription());

    }


    @Test
    void setNomTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"Objectif B14",4,1);
        b14bis.setNom("B14Modif");
        assertEquals("B14Modif",b14bis.getNom());

        b14bis.setNom("");
        assertEquals("B14Modif",b14bis.getNom());

        b14bis.setNom(null);
        assertEquals("B14Modif",b14bis.getNom());

    }


    @Test
    void setPointTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"Objectif B14",4,1);
        b14bis.setPoints(30);
        assertEquals(30,b14bis.getPoints());

        b14bis.setPoints(-20);
        assertEquals(30,b14bis.getPoints());
    }


    @Test
    void setStatutTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"Objectif B14",4,1);
        b14bis.setStatut(true);
        assertTrue(b14bis.isStatut());
    }



    @Test
    void setDescriptionTest() {
        ObjectifJardinier b14bis= new ObjectifJardinier("B14",20,false,"Objectif B14",4,1);
        b14bis.setDescription("Objectif B14Modif");
        assertEquals("Objectif B14Modif",b14bis.getDescription());

    }


}
