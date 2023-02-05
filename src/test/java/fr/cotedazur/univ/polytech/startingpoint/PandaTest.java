package fr.cotedazur.univ.polytech.startingpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PandaTest {
    Panda panda=new Panda();
    Parcelle p01=new Parcelle(new Position(0,1));
    List<Parcelle>parcelles=new ArrayList<>();
    @BeforeEach
    void setUp(){
        parcelles.add(p01);

    }

    @Test
    void creationPanda(){
        Panda panda=new Panda();
        assertEquals(panda.getName(),PersonnageName.Panda);
        assertEquals(panda.getPosition(),Parcelle.etang.getPosition());
    }
    @Test
    void  mangerBambouCasNormal(){
        assertEquals(1,p01.getTaille());
        panda.mangerBambou(p01,parcelles);
        assertEquals(0,p01.getTaille());

    }
    @Test
    void mangerBambouCasNonDansParcelles(){
        assertEquals(1,p01.getTaille());
        panda.mangerBambou(p01,new ArrayList<>());
        assertEquals(1,p01.getTaille());

    }
}
